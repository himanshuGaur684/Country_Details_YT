package com.gaur.countrydetails.presentation.country_details.compoents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gaur.countrydetails.domain.model.*
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CountryHeader(countyDetails: CountryDetails) {

    Text(
        text = countyDetails.names.full,
        style = TextStyle(color = Color.Black, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {


        Text(
            text = "Continet: " + countyDetails.names.continent,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "TimeZone: " + countyDetails.timezone.name,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(8.dp)
        )

    }


    Text(
        text = "Telephone",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    Text(
        text = "Ambulance: ${countyDetails.telephone.ambulance}",
        style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal),
        modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Calling Code: ${countyDetails.telephone.calling_code}",
        style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal),
        modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Police: ${countyDetails.telephone.police}",
        style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal),
        modifier = Modifier.padding(horizontal = 12.dp)
    )

    Text(
        text = "Fire: ${countyDetails.telephone.fire}",
        style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal),
        modifier = Modifier.padding(horizontal = 12.dp)
    )


}

@Composable
fun LanguageComp(language: List<Language>) {

    Text(
        text = "Languages",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    FlowRow {
        language.forEach {
            LanguageItem(language = it)
        }
    }


}

@Composable
fun LanguageItem(language: Language) {

    Card(
        modifier = Modifier
            .padding(12.dp)
            .wrapContentSize(), border = BorderStroke(1.dp, color = Color.Blue),
        shape = RoundedCornerShape(100.dp)
    ) {

        Text(
            modifier = Modifier.padding(8.dp),
            text = language.language,
            style = TextStyle(color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )

    }

}

@Composable
fun VaccinationsComp(vaccination: List<Vaccination>) {
    Text(
        text = "Vaccinations",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(vaccination) {
            VaccinationItem(vaccination = it)
        }
    }


}

@Composable
fun VaccinationItem(vaccination: Vaccination) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp), shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {

            Text(
                modifier = Modifier.padding(8.dp),
                text = vaccination.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                textDecoration = TextDecoration.Underline
            )

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp),
                text = vaccination.message,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal

                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

        }


    }

}

@Composable
fun CurrencyComp(currency: Currency) {
    Text(
        text = "Currency",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(currency.compare) {
            CurrencyItem(currency = currency, compare = it)
        }

    }


}

@Composable
fun CurrencyItem(currency: Currency, compare: Compare) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = if (currency.rate.toDouble() >= compare.rate.toDouble()) Color.Green else Color.Red
    ) {

        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = compare.name,
                style = TextStyle(color = Color.Black, fontSize = 14.sp),
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "1$ = " + compare.rate,
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = if (currency.rate.toDouble() >= compare.rate.toDouble()) "Low" else "High",
                style = TextStyle(color = Color.Black, fontSize = 16.sp),
                modifier = Modifier.padding(4.dp)
            )

        }


    }


}


@Composable
fun NeibhourComp(list: List<Neighbor>) {
    Text(
        text = "Neighbor",
        style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
        modifier = Modifier.padding(12.dp)
    )

    LazyRow {
        items(list) {
            NeighborItem(neighbor = it)
        }
    }


}

@Composable
fun NeighborItem(neighbor: Neighbor) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
    ) {

        Text(
            text = neighbor.name,
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(4.dp)
        )

    }

}













