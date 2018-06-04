package com.example.joochahyana.orderup;

import com.orm.SugarRecord;

public class DatabaseItemComment extends SugarRecord<DatabaseItemComment> {
    String          comment;

    // Relationship
    DatabaseItems   item;

    public DatabaseItemComment() {
    }

    public DatabaseItemComment(DatabaseItems item,String comment) {
        this.item = item;

        this.comment = comment;
    }
}
