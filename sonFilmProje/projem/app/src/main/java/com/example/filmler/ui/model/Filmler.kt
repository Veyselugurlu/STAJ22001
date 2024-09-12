package com.example.filmler.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "filmleri")
data class Filmler (@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "id") @NotNull var id : Int ,
                    @ColumnInfo(name = "ad") @NotNull var ad: String,
                    @ColumnInfo(name = "resim") @NotNull var resim: String,
                    @ColumnInfo(name = "fiyat") @NotNull var fiyat: Int)
: Serializable{
}