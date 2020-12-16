package com.eliteguzhva;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a filename");
            System.exit(0);
        }

        if (!args[0].endsWith(".xlsx")) {
            System.out.println("Filename should have .xlsx extension");
            System.exit(0);
        }

        String filename = "build/output/" + args[0];

        XlsxBuilder builder = new XlsxBuilder();
        boolean didBuild = builder.build(filename);

        if (didBuild) {
            System.out.println("Successfully built. Check build/output");
        } else {
            System.out.println("Couldn't build an XLSX file");
        }
    }
}
