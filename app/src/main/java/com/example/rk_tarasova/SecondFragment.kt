package com.example.rk_tarasova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_host.*

private lateinit var recyclerView: RecyclerView
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private lateinit var viewManager: RecyclerView.LayoutManager

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataSet: List<String> = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .map { it -> "item $it" }
        recyclerView = view.findViewById(R.id.my_recycler_view_1);
        recyclerView.setHasFixedSize(true);
        viewManager = LinearLayoutManager(view.getContext())
        viewAdapter = CustomListAdapter()
        (viewAdapter as CustomListAdapter).data = myDataSet

        recyclerView.setLayoutManager(viewManager)
        recyclerView.setAdapter(viewAdapter);
    }
}