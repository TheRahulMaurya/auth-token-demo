package com.learn.jwtdemo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    /**
     * Used to log info.
     *
     * @param obj        Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param httpStatus Response status.
     */
    public static void info(Object obj, String msg, int httpStatus) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": INFO: " + msg + ": STATUS: " + httpStatus);
    }

    /**
     * Used to log info.
     *
     * @param obj        Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param httpStatus Response status.
     * @param obj2       Used to print json data.
     */
    public static void info(Object obj, String msg, int httpStatus, Object obj2) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": INFO: " + msg + ": STATUS: " + httpStatus + " : " + gson.toJson(obj2));
    }

    /**
     * Used to log info.
     *
     * @param obj Used to get current object reference.
     * @param msg Append method name and message to it.
     */
    public static void info(Object obj, String msg) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": INFO: " + msg);
    }

    /**
     * Used to log info.
     *
     * @param msg Append method name and message to it.
     */
    public static void info(String msg) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": INFO: " + msg);
    }

    /**
     * Used to log error.
     *
     * @param obj        Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param httpStatus Response status.
     */
    public static void error(Object obj, String msg, int httpStatus) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": ERROR: " + msg + ": STATUS: " + httpStatus);
    }

    /**
     * Used to log error.
     *
     * @param obj Used to get current object reference.
     * @param msg Append method name and message to it.
     */
    public static void error(Object obj, String msg) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": ERROR: " + msg);
    }

    /**
     * Used to log error.
     *
     * @param msg Append method name and message to it.
     */
    public static void error(String msg) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": ERROR: " + msg);
    }

    /**
     * Used to log error.
     *
     * @param obj        Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param httpStatus Response status.
     * @param ex         Exception object.
     */
    public static void error(Object obj, String msg, int httpStatus, Exception ex) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": ERROR: " + msg + ": STATUS: " + httpStatus);
        ex.printStackTrace();
    }

    /**
     * Used to log error.
     *
     * @param obj        Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param httpStatus Response status.
     * @param msgJSON    to print json.
     */
    public static void error(Object obj, String msg, int httpStatus, Object msgJSON) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": ERROR: " + msg + ": STATUS: " + httpStatus + " : " + gson.toJson(msgJSON));
    }

    /**
     * @param ex Exception object.
     */
    public static void error(Object obj, String msg, Exception ex) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": ERROR: " + msg);
        ex.printStackTrace();
    }

    /**
     * Used to log error.
     *
     * @param msg Append method name and message to it.
     * @param ex  Exception object.
     */
    public static void error(String msg, Exception ex) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": ERROR: " + msg);
        ex.printStackTrace();
    }

    /**
     * Used for debugging purpose.
     *
     * @param obj1 Used to get current object reference.
     * @param msg  Append method name and message to it.
     * @param obj2 Object to add in log as json format.
     */
    public static void debug(Object obj1, String msg, Object obj2) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj1.getClass().getSimpleName() + ": DEBUG: " + msg + " : " + gson.toJson(obj2));
    }

    /**
     * Used for debugging purpose.
     *
     * @param obj1       Used to get current object reference.
     * @param msg        Append method name and message to it.
     * @param obj2       Object to add in log as json format.
     * @param httpStatus Response status.
     */
    public static void debug(Object obj1, String msg, Object obj2, int httpStatus) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj1.getClass().getSimpleName() + ": DEBUG:  STATUS: " + httpStatus + " : " + msg + " : " + gson.toJson(obj2));
    }

    /**
     * Used for debugging purpose.
     *
     * @param msg Append method name and message to it.
     * @param obj Object to add in log as json format.
     */
    public static void debug(String msg, Object obj) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": DEBUG: " + msg + " : " + gson.toJson(obj));
    }

    /**
     * Used for debugging purpose.
     *
     * @param obj Used to get current object reference.
     * @param msg Append method name and message to it.
     */
    public static void debug(Object obj, String msg) {
        System.out.println(sdf.format(new Timestamp(System.currentTimeMillis())) + ": " + obj.getClass().getSimpleName() + ": DEBUG: " + msg);
    }
}
