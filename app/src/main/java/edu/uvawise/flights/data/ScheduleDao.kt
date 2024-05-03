package edu.uvawise.flights.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: AirplaneSchedule)

    @Update
    suspend fun update(item: AirplaneSchedule)

    @Delete
    suspend fun delete(item: AirplaneSchedule)

    @Query("SELECT * from schedules WHERE id = :id")
    fun getItem(id: Int): Flow<AirplaneSchedule>

    @Query("SELECT * from schedules ORDER BY DepartureTime ASC")
    fun getAllItems(): Flow<List<AirplaneSchedule>>



}