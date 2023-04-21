package com.example.test.helper

//TODO: Selectable item in Grid and Row

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.test.R
import com.example.test.utils.Utils
import com.example.test.utils.Utils.imageUrls

@Composable
fun LogoImage(@DrawableRes resId: Int,modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Utils.backGroundColor),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = resId),
            contentDescription = "Logo Image",
            Modifier.size(70.dp)
        )
    }
}

@Composable
fun MainLayout() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Utils.backGroundColor)
    ) {

        LogoImage(R.drawable.logo)
        ConstraintImpl(
            "Complete your account",
            "Enter your name",
            "Enter your email address",
            "Please send me email other marketing communications \n" +
                    " regarding my account and other products.",
            imageUrls,
            "Select your teams for a more personalized experience",
            )
    }
}


@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun ConstraintImpl(
    title:String,
    hint1:String,
    hint2:String ,
    checkBoxBody:String,
    ImagesList :List<String>,
    titleGrid:String =" "
){

    val width = LocalConfiguration.current.screenWidthDp.dp
    val height = LocalConfiguration.current.screenHeightDp.dp
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val checkedState = remember{ mutableStateOf(false) }
    val configuration = LocalConfiguration.current

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .background(Utils.backGroundColor)) {
        val (
            completeYourAccountText,
            nameInputField,
            emailInputField,
            checkBoxLayout,
            checkBoxTeams,
        ) = createRefs()

        Text(
            text = title,
            fontFamily = Utils.acuminProFont,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color =  Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(completeYourAccountText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
        OutlinedTextField(
            value = text,
            label = { Text(text = hint1) },
            onValueChange = {
                text = it
            },
            maxLines = 1,
            modifier = Modifier
                .padding(5.dp)
                .width(width * 0.7f)
                .constrainAs(nameInputField) {
                    top.linkTo(completeYourAccountText.bottom, 35.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
        OutlinedTextField(
            value = text,
            label = { Text(text = hint2) },
            onValueChange = {
                text = it
            },
            maxLines = 1,
            modifier = Modifier
                .padding(5.dp)
                .width(width * 0.7f)
                .constrainAs(emailInputField) {
                    top.linkTo(nameInputField.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
        Row(
            modifier = Modifier
                .padding(top = 15.dp)
                .constrainAs(checkBoxLayout) {
                    top.linkTo(emailInputField.bottom)
                    start.linkTo(emailInputField.start)
                }
                .offset(x = (-5).dp)
                .fillMaxWidth(),
        ) {
            when  (configuration.orientation){
                Configuration.ORIENTATION_PORTRAIT ->{
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Utils.checkedColor,
                            uncheckedColor = Color.White.copy(alpha = 0.2f),
                            checkmarkColor = Color.White
                        ),
                        modifier = Modifier
                            .offset(y = (-12).dp)
                    )
                }
                Configuration.ORIENTATION_LANDSCAPE ->{
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Utils.checkedColor,
                            uncheckedColor = Color.White.copy(alpha = 0.2f),
                            checkmarkColor = Color.White
                        ),
                        modifier = Modifier
                            .scale(1.4f)
                            .offset(y = (-7).dp)

                    )
                }
                else ->Configuration.ORIENTATION_UNDEFINED
            }

            Text(
                text = checkBoxBody,
                fontFamily = Utils.acuminProFont,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .alignByBaseline()
            )
        }



        Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Utils.strokeColor.copy(alpha = 0.9f),
            ),
            modifier = Modifier
                .width(width * 0.7f)
                .padding(top = 30.dp, bottom = 30.dp)
                .wrapContentHeight()
                .constrainAs(checkBoxTeams) {
                    top.linkTo(checkBoxLayout.bottom)
                    start.linkTo(emailInputField.start)
                    end.linkTo(emailInputField.end)
                }
        ){

            when(configuration.orientation) {
                //CASE 1 ->WHEN  THE DEVICE IS IN PORTRAIT MODE  GRID WILL BE DISPLAYED
                Configuration.ORIENTATION_PORTRAIT -> {
                    Grid(ImagesList,titleGrid)
                }

                //CASE 2 ->WHEN  THE DEVICE IS IN PORTRAIT MODE ROW WILL BE DISPLAYED
                Configuration.ORIENTATION_LANDSCAPE -> {
                    Row(ImagesList)
                }
                else ->Configuration.ORIENTATION_UNDEFINED
            }
        }
    }
}

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
private fun Row(ImagesList: List<String>) {
    val checkedState = remember{ mutableStateOf(false) }
    Column(
        Modifier
            .padding(15.dp)
            .fillMaxWidth()) {
        LazyRow(
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .padding(top = 20.dp, bottom = 25.dp)
                .fillMaxWidth(),
            content = {
                items(ImagesList.size) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 15.dp)
                            .size(114.dp, 88.dp),
                        color = Color.White,
                        content = {
                            GlideImage(
                                model = ImagesList[it],
                                contentDescription = null, Modifier.size(75.dp)
                            )
                        },
                        shape = RoundedCornerShape(4.dp),
                        shadowElevation = 14.dp,
                        tonalElevation = 25.dp,
                    )
                }
            }
        )
        Row(
            modifier = Modifier
                .padding(end = 15.dp, start = 15.dp)
                .fillMaxWidth()
                .background(Color(0xff3a4765)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription =null,
                    Modifier.padding(10.dp).size(25.dp),
                    tint = Color.White
                )
                Text(
                    text = "Set Alerts",
                    fontFamily = Utils.acuminProFont,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier
                )
            }

            Switch(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                },
                modifier = Modifier.padding(end = 10.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Blue,
                    uncheckedThumbColor = Color.Red,
                    uncheckedTrackColor = Color.Gray,
                    checkedTrackColor = Color.White
                )
            )
        }
        Button(
            onClick ={},
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .padding(end = 15.dp, start = 15.dp, top = 20.dp, bottom = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff595d66),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Save & Continue",
                color = Color.White,
                fontFamily = Utils.acuminProFont,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
private fun Grid(ImagesList: List<String>, titleGrid: String) {
    val checkedState = remember{ mutableStateOf(false) }
    Column(
        Modifier
            .padding(
                end = 25.dp,
                start = 25.dp,
                top = 25.dp,
                bottom = 15.dp
            )
    ) {
        Text(
            text = titleGrid,
            fontFamily = Utils.acuminProFont,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            modifier = Modifier.padding(top = 15.dp, bottom = 10.dp),
            content = {
                items(ImagesList.size) {
                    Surface(
                        modifier = Modifier
                            .padding(all = 15.dp)
                            .size(80.dp, 115.dp),
                        color = Color.White,
                        content = {
                            GlideImage(
                                model = ImagesList[it],
                                contentDescription = null, Modifier.size(75.dp)
                            )
                        },
                        shape = RoundedCornerShape(4.dp),
                        shadowElevation = 14.dp,
                        tonalElevation = 25.dp,
                    )
                }
            },
            userScrollEnabled = false
        )
        Row(
            modifier = Modifier
                .padding(end = 15.dp, start = 15.dp)
                .fillMaxWidth()
                .background(Color(0xff3a4765)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Set Alerts",
                fontFamily = Utils.acuminProFont,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
            Switch(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                },
                modifier = Modifier.padding(end = 10.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Blue,
                    uncheckedThumbColor = Color.Red,
                    uncheckedTrackColor = Color.Gray,
                    checkedTrackColor = Color.White
                )
            )
        }
        Button(
            onClick ={},
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .padding(end = 15.dp, start = 15.dp, top = 20.dp, bottom = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff595d66),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Save & Continue",
                color = Color.White,
                fontFamily = Utils.acuminProFont,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}






