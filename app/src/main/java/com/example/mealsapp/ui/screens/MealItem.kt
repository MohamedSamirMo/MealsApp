package com.example.mealsapp.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealItem(
    modifier: Modifier = Modifier,
    title: String = "Delicious Meal",
    description: String = "Tasty and healthy meal with fresh ingredients",
    imageUrl: String = ""
    ,
    onFavoriteClick: () -> Unit = {}
) {
    // Animation for heart beat effect
    val infiniteTransition = rememberInfiniteTransition()
    val pulseAnimation by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutCirc),
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
//        onClick = {onFavoriteClick()},
        modifier
            .fillMaxWidth()
            .padding(15.dp).clickable {onFavoriteClick()}
            .clip(RoundedCornerShape(30.dp))  // تعديل الزوايا لتكون مستديرة أكثر
            .shadow(10.dp, RoundedCornerShape(30.dp)),  // ظل أقوى للكارد

        colors = CardDefaults.cardColors(Color(0xFFFAFAFA)),  // لون خلفية فاتح
        elevation = CardDefaults.cardElevation(15.dp)

    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF2196F3), Color(0xFF21CBF3))  // تدرج لوني جريء
                    )
                )
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                AsyncImage(
                    model = imageUrl,
                    contentDescription = imageUrl,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)  // حجم أكبر للصورة
                        .clip(CircleShape)
                        .shadow(6.dp, CircleShape)  // ظل أقوى للصورة
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White  // لون النص أبيض لتباين مع الخلفية
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = description,
                        fontSize = 16.sp,
                        color = Color.Black  // لون رمادي للنص الثانوي
                    )
                }

                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .scale(pulseAnimation)  // تطبيق تأثير النبض على الأيقونة
                        .padding(end = 10.dp),
                    tint = Color.Red  // لون أحمر للأيقونة لإضافة جاذبية
                )
            }
        }
    }
}
