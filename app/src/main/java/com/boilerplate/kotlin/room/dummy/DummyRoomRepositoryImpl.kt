package com.boilerplate.kotlin.room.dummy

import com.boilerplate.kotlin.repositories.room.DummyRoomRepository

class DummyRoomRepositoryImpl(
    private val dummyDao: DummyDao
) : DummyRoomRepository {
    override suspend fun getDummy(): Dummy? {
        return dummyDao.getDummy()
    }

    override suspend fun insertDummy(dummy: Dummy) {
        dummyDao.insert(dummy)
    }

    override suspend fun clearDummy() {
        dummyDao.clearDummy()
    }
}