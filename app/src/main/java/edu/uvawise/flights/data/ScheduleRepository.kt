package edu.uvawise.flights.data

import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<AirplaneSchedule>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<AirplaneSchedule?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: AirplaneSchedule)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: AirplaneSchedule)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: AirplaneSchedule)
}