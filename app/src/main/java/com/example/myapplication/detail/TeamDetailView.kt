package com.example.myapplication.detail

import com.example.myapplication.model.Team


interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}