package com.akash.meruva.my_manger.Task

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface taskDAO
{
    @Insert
    fun insert(task: Task12)

    @Delete
    fun delete(task: Task12)

    @Query("Select * from task_table order by id ASC")
    fun getAllTasks() : LiveData<List<Task12>>

    @Update
    fun updateuser(task: Task12)

}