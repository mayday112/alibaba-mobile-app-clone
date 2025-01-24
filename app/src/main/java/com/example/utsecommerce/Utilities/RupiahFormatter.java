package com.example.utsecommerce.Utilities;

import static java.text.NumberFormat.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class RupiahFormatter {


    public static String formatRupiah(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setCurrencySymbol("Rp");
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat formatter = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        formatter.setDecimalFormatSymbols(symbols);
        formatter.setPositivePrefix("Rp");
        formatter.setNegativePrefix("-Rp");
        formatter.setGroupingSize(3);
        formatter.setMaximumFractionDigits(2);

        return formatter.format(amount);
    }
}
