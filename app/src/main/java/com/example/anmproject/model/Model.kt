package com.example.anmproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Budgeting(
    @ColumnInfo(name="title")
    var idUser:String?,
    @ColumnInfo(name="title")
    var name:String?,
    @ColumnInfo(name="title")
    var budget:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}


@Entity
data class Expenses(
    @ColumnInfo(name="idUser")
    var idUser:String?,
    @ColumnInfo(name="idBudgeting")
    var idBudgeting:String?,
    @ColumnInfo(name="name")
    var name:String?,
    @ColumnInfo(name="tanggal")
    var tanggal:String?,
    @ColumnInfo(name="nominal")
    var nominal:String?,
    @ColumnInfo(name="deskripsi")
    var deskripsi:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}


@Entity
data class User(
    @ColumnInfo(name="username")
    var username:String?,
    @ColumnInfo(name="firstName")
    var firstName:String?,
    @ColumnInfo(name="lastName")
    var lastName:String?,
    @ColumnInfo(name="password")
    var password:String?

){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}


