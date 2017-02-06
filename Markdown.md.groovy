SEP = "|"
QUOTE     = "\'"
NEWLINE   = System.getProperty("line.separator")
TABLE_SEPARATOR = "---"

def printHead(columns) {
    OUT.append(SEP)
    columns.eachWithIndex { column, idx ->
        OUT.append(column.name()).append(SEP)
    }
    OUT.append(NEWLINE)

    columns.eachWithIndex { column, idx ->
        OUT.append(TABLE_SEPARATOR).append(SEP)
    }
    OUT.append(NEWLINE)
}

def record(columns, dataRow) {

    OUT.append(SEP)
    columns.eachWithIndex { column, idx ->
        def stringValue = FORMATTER.format(dataRow, column)
        OUT.append(stringValue)
        OUT.append(SEP)
    }
    OUT.append(NEWLINE)
}

printHead(COLUMNS)

ROWS.each { row -> record(COLUMNS, row) }
