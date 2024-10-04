package com.boilerplate.kotlin.repositories.room

import com.boilerplate.kotlin.room.dummy.Dummy

interface DummyRoomRepository {

        suspend fun getDummy(): Dummy?

        suspend fun insertDummy(dummy: Dummy)

        suspend fun clearDummy()
}