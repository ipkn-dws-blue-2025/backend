package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.dto.VmBaseDto;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import com.itmo.ipkn.team6.model.StatusVm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VmMockDataService {

    private VmBaseDtoList vmBaseDtoList;

    private final String PROJECT_ID = "1";

    @PostConstruct
    public void init() {
        vmBaseDtoList = createMockVmBaseDtoList();
    }

    public VmBaseDtoList getMockVmBaseDtoList() {
        return vmBaseDtoList;
    }

    private VmBaseDtoList createMockVmBaseDtoList() {
        VmBaseDtoList vmBaseDtoList = new VmBaseDtoList();

        List<VmBaseDto> servers = List.of(
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

    private VmBaseDto createVm(String id, String name, StatusVm status) {
        VmBaseDto vm = new VmBaseDto();
        vm.setId(id);
        vm.setName(name);
        vm.setStatus(status);
        vm.setProjectId(PROJECT_ID);
        return vm;
    }


    public void activeVm(String vmId) {

        for (VmBaseDto vmBaseDto : vmBaseDtoList.getServers()) {

            if (vmBaseDto.getId().equals(vmId)) {
                vmBaseDto.setStatus(StatusVm.ACTIVE);
                break;
            }

        }


    }

    public void shutoffVm(String vmId) {

        for (VmBaseDto vmBaseDto : vmBaseDtoList.getServers()) {

            if (vmBaseDto.getId().equals(vmId)) {
                vmBaseDto.setStatus(StatusVm.SHUTOFF);
                break;
            }

        }


    }
}
