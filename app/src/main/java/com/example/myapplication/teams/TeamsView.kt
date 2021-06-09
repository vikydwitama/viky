package com.example.myapplication.teams

import com.example.myapplication.model.Team


interface TeamsView {


    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}