package com.example.freshinthebox

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val imageRes: Int,
    val category: Int
)
data class Category(
    val id: Int,
    val name: String,
    val imageRes: Int
)

fun getSampleProducts(): List<Product> {
    return listOf(
        Product(1, "Ayam", "Rp15.000", R.drawable.ayam,3),
        Product(2, "Tomat", "Rp3.000", R.drawable.tomat,2),
        Product(3, "Wortel", "Rp4.000", R.drawable.wortel,1),
        Product(4, "Jeruk", "Rp6.000", R.drawable.jeruk,2)
    )
}

fun getSampleCategories(): List<Category> {
    return listOf(
        Category(1, "Sayuran", R.drawable.sayuran),
        Category(2, "Buah", R.drawable.buah),
        Category(3, "Daging", R.drawable.daging)
    )
}
