package com.example.mymoduleexample1.viewmodel

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.AndroidJob
import com.example.mymoduleexample1.R
import com.example.mymoduleexample1.extensions.inflate

class AndroidJobsAdapter: RecyclerView.Adapter<AndroidJobsAdapter.ViewHolder>() {

    var jobs: List<AndroidJob> = listOf()

    inner class  ViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.item_android_job)){

        fun bind(androidJob: AndroidJob) = with(itemView) {
            txtTitle.text = androidJob.title
            txtCountry.text = androidJob.country
            txtYears.text = androidJob.experienceTimeRequired

            chkNative.isCheked = androidJob.native
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
        ) = holder.bind(jobs[position])

    override fun getItemCount(): Int = jobs.size
}


}