package com.example.freshinthebox

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imageRes: Int,
    val category: Int
)
data class Category(
    val id: Int,
    val name: String,
    val imageRes: Int
)
data class Transaksi(
    val namaProduk: String,
    val jumlah: Int,
    val totalHarga: Double,
    val timestamp: Long = System.currentTimeMillis()
)
val transactionList = mutableListOf<Transaksi>()


fun getSampleProducts(): List<Product> {
    return listOf(
        Product(1, "Ayam", 15000, R.drawable.ayam,3),
        Product(2, "Tomat", 3000, R.drawable.tomat,2),
        Product(3, "Wortel", 4000, R.drawable.wortel,1),
        Product(4, "Jeruk", 6000, R.drawable.jeruk,2)
    )
}

fun getSampleCategories(): List<Category> {
    return listOf(
        Category(1, "Sayuran", R.drawable.sayuran),
        Category(2, "Buah", R.drawable.buah),
        Category(3, "Daging", R.drawable.daging)
    )
}

fun saveTransaction(productName: String, quantity: Int, totalPrice: Double) {
    val transaction = Transaksi(
        namaProduk = productName,
        jumlah = quantity,
        totalHarga = totalPrice
    )
    transactionList.add(transaction)
}



