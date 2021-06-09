package com.example.myapplication.teams

import com.example.myapplication.api.ApiRepository
import com.example.myapplication.api.TheSportDBApi
import com.example.myapplication.model.TeamResponse
import com.example.myapplication.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getTeamList(league: String?) {
        view.showLoading()

        GlobalScope.launch (context.main){
            val data = gson.fromJson(apiRepository
                        .doRequestAsync(TheSportDBApi.getTeams(league)).await(),
                        TeamResponse::class.java)

            view.showTeamList(data.teams)
            view.hideLoading()
        }
    }
}