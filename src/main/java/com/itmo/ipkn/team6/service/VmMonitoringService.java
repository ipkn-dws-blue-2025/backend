package com.itmo.ipkn.team6.service;


import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringApiClient;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import com.itmo.ipkn.team6.dto.VmBaseMetricDto;
import com.itmo.ipkn.team6.dto.*;
import com.itmo.ipkn.team6.exception.InvalidJwtTokenException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.OperatorToken;
import com.itmo.ipkn.team6.model.StatusVm;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.OperatorTokenJpaRepository;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class VmMonitoringService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final VmControlApiClient vmControlApiClient;
    private final VmMonitoringApiClient vmMonitoringApiClient;
    private final ServiceEncrypt serviceEncrypt;
    private final OperatorTokenJpaRepository operatorTokenJpaRepository;

    private final String projectIdForMockVm = "2";

    @Value("${encryption.jwt-key}")
    private String jwtKey;

    public VmBaseDtoList getListOfVms(Long userId) {

        String encryptedToken = getToken(userId);

        String token = serviceEncrypt.decrypt(encryptedToken);

        // имитация создания стенда с мок данными
        if (token.equals("00000")) {

            return createMockVmBaseDtoList();

        }

        return vmControlApiClient.getVmList(token);

    }


    public VmBaseMetricDto getVmBaseMetric(Long userId, String projectId, String vmId) {

        String encryptedToken = getToken(userId);

        String token = serviceEncrypt.decrypt(encryptedToken);

        if (token.equals("00000")) {

            return createVmBaseMetricDto();

        }

        // {vm_uuid="f6c93c10-7278-4a5c-bcb1-293c6a48c9f6"} - пример query
        String query = "{vm_uuid=\"" + vmId + "\"}";
        VmBaseMetricResponse vmBaseMetricResponse = vmMonitoringApiClient.getVmBaseMetrics(token, projectId, query);


        double cpuSystemPercent = 0;
        double cpuUserPercent = 0;
        double ramUsedPercent = 0;
        double diskUsedPercent = 0;

        double totalCpuPercent;

        for (VmBaseMetricResponse.MonitoringResult result : vmBaseMetricResponse.getData().getResult()) {

            String metricName = result.getMetric().getName();

            String valueStr = result.getValue().get(1).toString();
            double value = Double.parseDouble(valueStr);

            if ("cpu_usage_system".equals(metricName)) {
                cpuSystemPercent = value;
            } else if ("cpu_usage_user".equals(metricName)) {
                cpuUserPercent = value;
            } else if ("mem_used_percent".equals(metricName)) {
                ramUsedPercent = value;
            } else if ("disk_used_percent".equals(metricName)) {
                diskUsedPercent = value;
            }


        }

        totalCpuPercent = cpuSystemPercent + cpuUserPercent;

        // округление до двух знаков после запятой
        totalCpuPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", totalCpuPercent));
        diskUsedPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", diskUsedPercent));
        ramUsedPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", ramUsedPercent));

        return VmBaseMetricDto.builder()
                .cpuLoadPercent(totalCpuPercent)
                .diskUsedPercent(diskUsedPercent)
                .ramUsedPercent(ramUsedPercent)
                .timestamp(LocalDateTime.now())
                .build();

    }

    /**
     * Создание моковых метрик для стенда тестирования
     *
     * @return
     */
    private VmBaseMetricDto createVmBaseMetricDto() {


        ThreadLocalRandom localRandom = ThreadLocalRandom.current();

        // округление до двух знаков после запятой
        Double cpuLoadPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", localRandom.nextDouble(0, 100)));
        Double ramUsedPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", localRandom.nextDouble(0, 100)));
        Double diskUsedPercent = Double.parseDouble(String.format(Locale.US, "%.2" + "f", localRandom.nextDouble(0, 100)));


        return VmBaseMetricDto.builder()
                .cpuLoadPercent(cpuLoadPercent)
                .ramUsedPercent(ramUsedPercent)
                .diskUsedPercent(diskUsedPercent)
                .timestamp(LocalDateTime.now())
                .build();

    }


    /**
     * Создание мок данных для списка виртуальных машин для стенда тестирования
     *
     * @return
     */
    private VmBaseDtoList createMockVmBaseDtoList() {


        VmBaseDtoList vmBaseDtoList = new VmBaseDtoList();

        List<VmBaseDto> servers;

        servers = List.of(
                createVm(UUID.randomUUID().toString(), "kafka-prod-01", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "kafka-prod-02", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "rabbitmq-main", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "rabbitmq-backup", StatusVm.SHUTOFF),
                createVm(UUID.randomUUID().toString(), "postgres-primary", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "postgres-replica", StatusVm.SHUTOFF),
                createVm(UUID.randomUUID().toString(), "nginx-loadbalancer", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "redis-cache", StatusVm.SHUTOFF),
                createVm(UUID.randomUUID().toString(), "elasticsearch-node-1", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "mongodb-shard-01", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "prometheus-monitoring", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "grafana-dashboard", StatusVm.ACTIVE),
                createVm(UUID.randomUUID().toString(), "jenkins-ci", StatusVm.ACTIVE));

        vmBaseDtoList.setServers(servers);
        return vmBaseDtoList;

    }

    /**
     * Создание моковых ВМ
     *
     * @return
     */
    private VmBaseDto createVm(String id, String name, StatusVm statusVm) {

        VmBaseDto vmBaseDto = new VmBaseDto();
        vmBaseDto.setId(id);
        vmBaseDto.setName(name);
        vmBaseDto.setStatus(statusVm);
        vmBaseDto.setProjectId(projectIdForMockVm);

        return vmBaseDto;
    }

    /**
     * Получает токен из БД.
     * Смотрит сначала админский токен, если не находит, то проверяет токен оператора.
     */
    private String getToken(Long userId) {

        Optional<VkCloudToken> vkCloudToken = vkCloudTokenJpaRepository.findByUserId(userId);


        if (vkCloudToken.isPresent()) {

            // тут случай, если пользователь админ
            return vkCloudToken.get().getEncryptedAdminToken();

        }


        OperatorToken operatorToken = operatorTokenJpaRepository.findByOperatorUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для доступа к VK Cloud не найден. Добавьте VK Cloud токен или токен оператора."));

        // проверим, что jwtToken верный
        try {

            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(operatorToken.getJwtToken());

            VkCloudToken cloudTokenAdmin = vkCloudTokenJpaRepository.findByUserId(operatorToken.getAdminUserId()).orElseThrow(() -> new NotFoundToken("Не найден токен. Обратитесь к администратору, который вам его выдавал (он должен добавить в своём кабинете токен от VK Cloud)."));

            return cloudTokenAdmin.getEncryptedAdminToken();

        } catch (ExpiredJwtException e) {

            throw new InvalidJwtTokenException("Срок действия токена истек. Получите новый токен у администратора.");

        } catch (SignatureException e) {

            throw new InvalidJwtTokenException("Неверный токен, обратитесь к администратору.");

        } catch (JwtException e) {

            throw new InvalidJwtTokenException("Неверный токен, обратитесь к администратору.");

        }

    }


}
