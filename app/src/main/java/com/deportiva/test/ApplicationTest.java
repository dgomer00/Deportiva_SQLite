package com.deportiva.test;

import android.app.Application;
import android.content.pm.PackageManager;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testPermissionWriteExternal(){
        String permission = "android.permission.WRITE_EXTERNAL_STORAGE";
        int res = getContext().checkCallingOrSelfPermission(permission);
        boolean resultado= (res == PackageManager.PERMISSION_GRANTED);
        Assert.assertTrue(resultado);
    }

    public void testPermissionInternet(){
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

    /*----------------------------------------

    Hacer tests para las paginas web, los periodicos y la pagina de enlaces.
    Tests para ver que se inicia la Acivity correcta de los cases

    //-----------------------------------------------*/
    public void testHttpGetMarcadores() {
        HttpGet httpget = new HttpGet("http://www.movil.resultados-futbol.com/segunda");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    public void testHttpGetClasificacion() {
        HttpGet httpget = new HttpGet("http://www.marcadores.com/futbol/espana/liga-adelante/clasificacion.html");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    public void testHttpGetCalendarioLfp() {
        HttpGet httpget = new HttpGet("http://www.lfp.es/calendario-horario");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    public void testHttpGetCalendarioMarca() {
        HttpGet httpget = new HttpGet("http://www.marca.com/movil/tabla_marcadores.html?c=futbol_2adivision");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    public void testHttpGetCalendarioMundoDeportivo() {
        HttpGet httpget = new HttpGet("http://www.mundodeportivo.com/futbol/liga-segunda-division/calendario.html");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

    public void testHttpGetCalendarioElPais() {
        HttpGet httpget = new HttpGet("http://www.elpais.com/especial/calendario-liga-futbol/segunda/");
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
        } catch(Exception e) {
            fail("Excepcion");
        }

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode() );
    }

}