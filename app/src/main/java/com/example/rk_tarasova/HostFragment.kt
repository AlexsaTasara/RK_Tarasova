package com.example.rk_tarasova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_host.*

class HostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_frag.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_secondFragment)
        )
        button_BTC.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_btmFragment)
        )
    }
}