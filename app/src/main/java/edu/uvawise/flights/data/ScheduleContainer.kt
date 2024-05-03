package edu.uvawise.flights.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val scheduleRepository: ScheduleRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ScheduleRepository]
     */
    override val scheduleRepository: ScheduleRepository by lazy {
        OfflineScheduleRepository(ScheduleDatabase.getDatabase(context).scheduleDao())
    }
}
