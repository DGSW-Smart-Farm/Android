package com.example.smartfarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StateAdapter : RecyclerView.Adapter<StateAdapter.ViewHolder>() {
    var stateList: List<State> = ArrayList<State>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context);
        val view: View = inflater.inflate(R.layout.state_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stateList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var state: State = stateList.get(position)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}