/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.uvawise.flights.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedules")
data class AirplaneSchedule(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int, //ident from flightaware.com

    @ColumnInfo(name = "Departure Airport")
    val Departure: String, //Starting location for the flight

    @ColumnInfo(name = "Arrival Airport")
    val Arrival: String, //Ending location for the flight

    @ColumnInfo(name = "Departure Time")
    val DepartureTime: String, //Time for departure

    @ColumnInfo(name = "Arrival Time")
    val ArrivalTime: String, //Time for arrival

    @ColumnInfo(name = "Airline")
    val airlineName: String //Name of the airline
)
