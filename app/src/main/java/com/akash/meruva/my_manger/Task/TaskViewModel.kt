package com.akash.meruva.my_manger.Task


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Taskviewmodel(applcation : Application): AndroidViewModel(applcation)
{
    private val repository: TaskRepository
    val alltasks : LiveData<List<Task12>>

    init {
        val dao = TaskDatabase.getDatabase(applcation).getTaskDao()
        repository = TaskRepository(dao)
        alltasks = repository.alltasks
    }

    fun dletetask(task : Task12) = viewModelScope.launch(Dispatchers.IO)
    {
        repository.delete(task)
    }

    fun InsertTask( task : Task12) = viewModelScope.launch (Dispatchers.IO )
    {
        repository.insert(task)
    }

    fun Updatetas(task: Task12) = viewModelScope.launch ( Dispatchers.IO )
    {
        repository.update(task)
    }
}