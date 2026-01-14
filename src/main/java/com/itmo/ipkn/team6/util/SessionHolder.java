package com.itmo.ipkn.team6.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SessionHolder {

    public static List<Long> activeUserIds = new CopyOnWriteArrayList<>();
}
