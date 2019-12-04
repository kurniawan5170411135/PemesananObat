<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AccountActivity">
    <TextView
        android:id="@+id/acc"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="My Account"
        android:textSize="36sp" />

    <TextView
        android:id="@+id/nama"
        android:layout_width="125dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/acc"
        android:layout_marginStart="5dp"
        android:layout_marginTop="5dp"
        android:layout_marginEnd="5dp"
        android:layout_marginBottom="5dp"
        android:text="NAMA"
        android:textColor="#FD0A0A0A"
        android:textSize="18sp" />


    <TextView
        android:id="@+id/nim"
        android:layout_width="125dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/nama"
        android:layout_marginStart="5dp"
        android:layout_marginTop="5dp"
        android:layout_marginEnd="5dp"
        android:layout_marginBottom="5dp"
        android:text="NIM"
        android:textColor="#0E0D0D"
        android:textSize="18sp" />


    <TextView
        android:id="@+id/nama2"
        android:layout_width="125dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/acc"
        android:layout_marginStart="5dp"
        android:layout_marginTop="5dp"
        android:layout_marginEnd="5dp"
        android:layout_marginBottom="5dp"
        android:layout_toRightOf="@id/nama"
        android:textColor="#F80E0D0D"
        android:textSize="18sp" />


    <TextView
        android:id="@+id/nim2"
        android:layout_width="125dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/nama2"
        android:layout_marginStart="5dp"
        android:layout_marginTop="5dp"
        android:layout_marginEnd="5dp"
        android:layout_marginBottom="5dp"
        android:lay