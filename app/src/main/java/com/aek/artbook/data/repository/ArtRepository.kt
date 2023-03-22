package com.aek.artbook.data.repository

import com.aek.artbook.data.source.local.LocalDataSource
import com.aek.artbook.data.source.remote.RemoteDataSource

interface ArtRepository : LocalDataSource, RemoteDataSource
