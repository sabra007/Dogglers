/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODOne: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    val myDataset = dogs


    class DogCardViewHolder(private val view: View): RecyclerView.ViewHolder(view!!) {
        // TODOne: Declare and initialize all of the list item UI components
        val imageView: ImageView = view.findViewById(R.id.dog_image)
        val textViewName: TextView = view.findViewById(R.id.dog_name)
        val textViewAge: TextView = view.findViewById(R.id.dog_age)
        val textViewHobbies: TextView = view.findViewById(R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODOne: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used. var v = if (a) b else c

        val layout = if (viewType == 3) R.layout.grid_list_item else R.layout.vertical_horizontal_list_item

        // TODOne Inflate the layout

        val adapterLayout = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        // TODOne: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int =  myDataset.size // TODOne: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {


        //holder.textView.text = context.resources.getString(item.stringResourceId)
        //holder.imageView.setImageResource(item.imageResourceId)

        // TODOne: Get the data at the current position
        val item = myDataset[position]

        // TODOne: Set the image resource for the current dog
        holder.imageView.setImageResource(item.imageResourceId)

        // TODOne: Set the text for the current dog's name
        holder.textViewName.text = item.name

        // TODOne: Set the text for the current dog's age

        val resources = context?.resources

        // TODOne: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        //  holder.textView.text = context.resources.getString(item.stringResourceId)

        holder.textViewAge.text = resources?.getString(R.string.dog_age, item.age)

        holder.textViewHobbies.text = resources?.getString(R.string.dog_hobbies, item.hobbies)

    }
}
