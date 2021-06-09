package com.example.myapplication.detail


import com.example.myapplication.api.ApiRepository
import com.example.myapplication.api.TheSportDBApi
import com.example.myapplication.model.TeamResponse
import com.example.myapplication.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamDetail(teamId: String) {
        view.showLoading()

        GlobalScope.launch (context.main){
            val data = gson.fromJson(apiRepository
                    .doRequestAsync(TheSportDBApi.getTeamDetail(teamId) as String).await(),
                    TeamResponse::class.java)

            view.showTeamDetail(data.teams)
            view.hideLoading()
        }
    }
}