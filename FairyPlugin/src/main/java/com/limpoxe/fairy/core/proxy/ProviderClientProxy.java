package com.limpoxe.fairy.core.proxy;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;

import com.limpoxe.fairy.manager.PluginProviderClient;
import com.limpoxe.fairy.util.LogUtil;

/**
 * Created by cailiming on 2017/11/27.
 */
public class ProviderClientProxy extends ContentProvider {

    public ProviderClientProxy() {
       LogUtil.d("create provider proxy instance");
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        LogUtil.d("query", uri);
        return PluginProviderClient.query(uri, strings, s, strings1, s1);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, Bundle queryArgs, CancellationSignal cancellationSignal) {
        LogUtil.d("query", uri);
        return PluginProviderClient.query(uri, projection, queryArgs, cancellationSignal);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        LogUtil.d("query", uri);
        return PluginProviderClient.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    @Override
    public String getType(Uri uri) {
        LogUtil.d("getType", uri);
        return PluginProviderClient.getType(uri);
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        LogUtil.d("insert", uri);
        return PluginProviderClient.insert(uri, contentValues);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        LogUtil.d("delete", uri);
        return PluginProviderClient.delete(uri, s, strings);
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        LogUtil.d("update", uri);
        return PluginProviderClient.update(uri, contentValues, s, strings);
    }

    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        //约定：原始url被吞掉了，所以调用这个函数的时候需要同时将原始url放入extras
        LogUtil.d("target_call");
        if (extras != null && extras.getParcelable("target_call") != null) {
            return PluginProviderClient.call(method, arg, extras);
        }
        return null;
    }

}
