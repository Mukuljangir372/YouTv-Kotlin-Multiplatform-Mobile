package com.mukul.youtv.android.features.ui_movie_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mukul.youtv.android.common.ui.Dimens
import com.mukul.youtv.android.common.ui.components.MovieListView

@Composable
fun MovieListScreen() {
    MovieListScreen(
        viewModel = hiltViewModel()
    )
}

@Composable
private fun MovieListScreen(
    viewModel: MovieListViewModel
) {
    val state by viewModel.state.collectAsState()

    MovieListScreen(
        state = state,
        onScrollPositionChange = { position ->
            viewModel.onScrollPositionChange(
                position = position
            )
        }
    )
}

@Composable
private fun MovieListScreen(
    state: MovieListUiState,
    onScrollPositionChange: (position: Int) -> Unit,
) {
    val scaffoldState = rememberScaffoldState()
    val movies = state.movies

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(Dimens.One),
                columns = GridCells.Fixed(count = 2),
                horizontalArrangement = Arrangement.spacedBy(Dimens.One + Dimens.Half),
                verticalArrangement = Arrangement.spacedBy(Dimens.One + Dimens.Half),
                content = {
                    itemsIndexed(movies) { index, movie ->
                        onScrollPositionChange(index)
                        MovieListView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(Dimens.Twenty + Dimens.Nine),
                            movie = movie
                        )
                    }
                }
            )
        }
    }
}
















