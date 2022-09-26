package com.akash.meruva.my_manger.Task


import androidx.lifecycle.LiveData

class TaskRepository(private val Taskdao : taskDAO){

    val alltasks : LiveData<List<Task12>> = Taskdao.getAllTasks()

    suspend fun insert(task : Task12)
    {
        Taskdao.insert(task)
    }

    suspend fun delete(task : Task12)
    {
        Taskdao.delete(task)
    }

    suspend fun update(task: Task12)
    {
        Taskdao.updateuser(task)
    }

}