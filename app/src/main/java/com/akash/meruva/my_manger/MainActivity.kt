package com.akash.meruva.my_manger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.akash.meruva.my_manger.Goals.GoalsFragment
import com.akash.meruva.my_manger.Task.Tasksfragment
import com.akash.meruva.my_manger.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replacefragment(DashboardFragment())

        binding.bottomnav.setOnItemSelectedListener{ item ->
            when (item.itemId)
            {

                R.id.dashboardnavigate ->
                {
                    replacefragment(DashboardFragment())
                }

                R.id.tasknavigate -> {
                    replacefragment(Tasksfragment())
                }

                R.id.gridnavigate -> {
                    replacefragment(Timetableragment())
                }

                R.id.goalsnavigate -> {
                    replacefragment(GoalsFragment())
                }

                R.id.profilenavigate -> {
                    replacefragment(ProfileFragment())
                }
            }

            return@setOnItemSelectedListener true
        }


    }



    private fun replacefragment(fragment : Fragment)
    {
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace( R.id.fragmentcontainer , fragment)
        fragmentTransaction.commit()
    }
}