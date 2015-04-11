package com.deportiva.test;

import android.app.Application;
import android.content.pm.PackageManager;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testPermissionWriteExternal() throws Throwable{
        String permission = "android.permission.WRITE_EXTERNAL_STORAGE";
        int res = getContext().checkCallingOrSelfPermission(permission);
        boolean resultado= (res == PackageManager.PERMISSION_GRANTED);
        Assert.assertTrue(resultado);
    }

    public void testPermissionInternet() throws Throwable{
        String permission = "android.permission.INTERNET";
        int res = getContext().checkCallingOrSelfPermission(permission);
        boolean resultado= (res == PackageManager.PERMISSION_GRANTED);
        Assert.assertTrue(resultado);
    }

    public void testPermissionNotNetworkState(){
        String permission = "android.permission.ACCESS_NETWORK_STATE";
        int res = getContext().checkCallingOrSelfPermission(permission);
        boolean resultado= (res == PackageManager.PERMISSION_GRANTED);
        Assert.assertFalse(resultado);
    }

    public void testPermissionNotWriteContacts(){
        String permission = "android.permission.WRITE_CONTACTS";
        int res = getContext().checkCallingOrSelfPermission(permission);
        boolean resultado= (res == PackageManager.PERMISSION_GRANTED);
        Assert.assertFalse(resultado);
    }
}