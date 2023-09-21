package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.models.datas.Employee
import com.shegs.miragefood.models.datas.SearchUIState
import com.shegs.miragefood.viewmodels.SearchViewModel


@Composable
fun SearchScreen(searchViewModel: SearchViewModel){


    val uiState = searchViewModel.searchUIState.collectAsState().value
    val searchText = searchViewModel.searchText.collectAsState().value
    val recentSearches = searchViewModel.recentSearches.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Search for a Co-worker",
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.scrim
        )
        Spacer(modifier = Modifier.height(20.dp))
        SearchTextField(
            hint = "Search co-worker",
            value = searchText,
            onValueChange = searchViewModel::onSearchTextChange
        )
        Spacer(modifier = Modifier.height(20.dp))
        when(uiState){
            is SearchUIState.Empty -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ){
                    Text(
                        text = "No matching Items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.scrim
                    )
                }
            }
            is SearchUIState.Loading ->{
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ){
                    CircularProgressIndicator()
                }
            }
            is SearchUIState.Success ->{
                EmployeeListSection(
                    title = "Results",
                    employees = uiState.employees,
                    modifier = Modifier.weight(1f),
                    onItemClick = {
                        searchViewModel.addToRecents(it)
                    }
                )
            }
            is SearchUIState.Error ->{
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ){
                    Text(
                        text = "Error searching items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.scrim
                    )
                }
            }
            is SearchUIState.Idle ->{
                if(recentSearches.isNotEmpty()){
                    EmployeeListSection(
                        title = "Recent Searches",
                        employees = recentSearches,
                        modifier = Modifier.weight(1f),
                        onItemClick = {}
                    )
                }
            }
        }
    }
}

@Composable
fun EmployeeListSection(
    title: String,
    employees: List<Employee>,
    modifier: Modifier = Modifier,
    onItemClick: (Employee) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.scrim
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f),
        ){
            items(employees.size){index ->
                EmployeeListItem(
                    employee = employees[index],
                    onItemClick = {
                        onItemClick(employees[index])
                    }
                )
            }
        }
    }
}

@Composable
fun SearchTextField(
    hint: String,
    value: String,
    onValueChange: (String)->Unit
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search icon"
            )
        },
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodySmall.copy(
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.W500,
                    fontSize = 12.sp
                )
            )
        }
    )
}

@Composable
fun EmployeeListItem(
    employee: Employee,
    modifier: Modifier = Modifier,
    onItemClick: ()-> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onItemClick()
            },
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = employee.image),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = employee.name,
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.scrim
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = employee.department,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim,
            )
        }

    }
}