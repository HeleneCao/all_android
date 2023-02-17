package fr.ch.routardapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ch.routardapp.network.Pays
import fr.ch.routardapp.network.PaysApi
import kotlinx.coroutines.launch

enum class PaysApiStatus {LOADING, ERROR, DONE}

class PaysViewModel : ViewModel() {

    private val _statut = MutableLiveData<PaysApiStatus>()
    val status : LiveData<PaysApiStatus> = _statut

    private val _payss = MutableLiveData<List<Pays>>()
    val payss : LiveData<List<Pays>> = _payss

    private val _pays = MutableLiveData<Pays>()
    val pays : LiveData<Pays> = _pays

    fun getPaysList(){
        viewModelScope.launch {
            _statut.value = PaysApiStatus.LOADING
            try{
                _payss.value = PaysApi.retrofitService.getPays()
                _statut.value = PaysApiStatus.DONE
            } catch (e: Exception){
                _statut.value = PaysApiStatus.ERROR
                _payss.value = listOf()
            }
        }
    }

    fun onPaysClicked(pays : Pays){
        _pays.value = pays
    }
}