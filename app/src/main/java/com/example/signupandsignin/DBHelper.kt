package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,"User.db",null,1) {
   var sdb:SQLiteDatabase = writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null) {
            p0.execSQL("create table users ( id integer primary key,name text,mobile text,location text,password text)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun saveddata(n1:String,n2:String,n3:String,n4:String): Long {
        val cv = ContentValues()
        cv.put("name",n1)
        cv.put("mobile",n2)
        cv.put("location",n3)
        cv.put("password",n4)
        var status = sdb.insert("users",null,cv)
        return status
    }

//    @SuppressLint("Range")
//    fun retriveData(s1:String):String{
//        var c :Cursor = sdb.query("student",null,"name=?", arrayOf(s1),null,null,null)
//        c.moveToFirst()
//        var loc =  c.getString(c.getColumnIndex("location"))
//        return loc
//    }

    @SuppressLint("Range")
    fun retriveData():MutableList<String>{
        var al = mutableListOf<String>()
        var c : Cursor = sdb.query("users",null,null, null,null,null,null)
        if (c.moveToFirst()) {
            do {
                var name =   c.getString(c.getColumnIndex("name"))

                al.add(name)
            } while (c.moveToNext());
        }
        return al
    }

    @SuppressLint("Range")
    fun retriveDatawith(s1:String):String{
        var c :Cursor = sdb.query("users",null,"mobile=?", arrayOf(s1),null,null,null)
        c.moveToFirst()
        var loc =  c.getString(c.getColumnIndex("location"))
        var name = c.getString(c.getColumnIndex("name"))
        var data = "$name\n$loc\n"
        return data
    }

    @SuppressLint("Range")
    fun retrivePasswith(s1:String):String{
        var data = ""
        var c :Cursor = sdb.query("users",null,"name=?", arrayOf(s1),null,null,null)
        if (c.count == 0){
            data = "Not found"
        }else {
        c.moveToFirst()

         data = c.getString(c.getColumnIndex("password"))}
        return data
    }

    @SuppressLint("Range")
    fun retriveMobwith(s1:String):String{
        var c :Cursor = sdb.query("users",null,"name=?", arrayOf(s1),null,null,null)
    c.moveToFirst()
    var data = c.getString(c.getColumnIndex("mobile"))

        return data
    }
}