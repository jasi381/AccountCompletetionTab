package com.example.test

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ItemsImage(@DrawableRes image: Int) {

    //TODO" add selected image to the list

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.clip(RoundedCornerShape(10.dp)),
        content = {
            items(12) {

                var selectedItem by remember {
                    mutableStateOf(false)
                }

                Box( modifier = Modifier
                    .padding(5.dp)
                    .size(120.dp, 160.dp)

                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 0.5f)
                        rotationY = 45f
                        shape = TriangleShape
                    }
                    .rotate(45f)
                    .selectable(
                        selected = selectedItem == !selectedItem,
                        onClick = { selectedItem = !selectedItem }),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        border = if (selectedItem) BorderStroke(
                            2.dp,
                            Color.Black
                        ) else BorderStroke(0.dp, Color.Transparent),
                        shape = TriangleShape
                    ) {
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    if (selectedItem) {
                        Surface(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(com.example.test.TriangleShape),
                            color = Color.Black,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_check_24),
                                contentDescription = "image",
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(com.example.test.TriangleShape) ,
                                contentScale = ContentScale.Inside
                            )
                        }
                    }else{

                    }
                }
            }
        }
    )

}
private val TriangleShape = GenericShape { size, _ ->
    // 1)
//    moveTo(size.width / 8f, 0f)
//
//    // 2)
//    lineTo(size.width, size.height)
//
//    // 3)
//    lineTo(0f, size.height)
    moveTo(size.width * 0.7f, size.height * 0.7f)
    lineTo(size.width * 0.7f, 0f)
    lineTo(0f, size.height * 0.7f)
}

