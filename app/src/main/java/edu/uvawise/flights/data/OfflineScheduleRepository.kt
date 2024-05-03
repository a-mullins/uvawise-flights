package edu.uvawise.flights.data

import kotlinx.coroutines.flow.Flow

class OfflineScheduleRepository(private val scheduleDao: ScheduleDao): ScheduleRepository {
    override fun getAllItemsStream(): Flow<List<AirplaneSchedule>> = scheduleDao.getAllItems()

    override fun getItemStream(id: Int): Flow<AirplaneSchedule?> = scheduleDao.getItem(id)

    override suspend fun insertItem(item: AirplaneSchedule) = scheduleDao.insert(item)

    override suspend fun deleteItem(item: AirplaneSchedule) = scheduleDao.delete(item)

    override suspend fun updateItem(item: AirplaneSchedule) = scheduleDao.update(item)
}