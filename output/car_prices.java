// ORM class for table 'car_prices'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sun Apr 14 20:00:49 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class car_prices extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("year", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.year = (Integer)value;
      }
    });
    setters.put("make", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.make = (String)value;
      }
    });
    setters.put("model", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.model = (String)value;
      }
    });
    setters.put("trim", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.trim = (String)value;
      }
    });
    setters.put("body", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.body = (String)value;
      }
    });
    setters.put("transmission", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.transmission = (String)value;
      }
    });
    setters.put("vin", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.vin = (String)value;
      }
    });
    setters.put("state", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.state = (String)value;
      }
    });
    setters.put("condition", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.condition = (Integer)value;
      }
    });
    setters.put("odometer", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.odometer = (Integer)value;
      }
    });
    setters.put("color", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.color = (String)value;
      }
    });
    setters.put("interior", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.interior = (String)value;
      }
    });
    setters.put("seller", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.seller = (String)value;
      }
    });
    setters.put("mmr", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.mmr = (Integer)value;
      }
    });
    setters.put("sellingprice", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.sellingprice = (Integer)value;
      }
    });
    setters.put("saledate", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        car_prices.this.saledate = (java.sql.Timestamp)value;
      }
    });
  }
  public car_prices() {
    init0();
  }
  private Integer year;
  public Integer get_year() {
    return year;
  }
  public void set_year(Integer year) {
    this.year = year;
  }
  public car_prices with_year(Integer year) {
    this.year = year;
    return this;
  }
  private String make;
  public String get_make() {
    return make;
  }
  public void set_make(String make) {
    this.make = make;
  }
  public car_prices with_make(String make) {
    this.make = make;
    return this;
  }
  private String model;
  public String get_model() {
    return model;
  }
  public void set_model(String model) {
    this.model = model;
  }
  public car_prices with_model(String model) {
    this.model = model;
    return this;
  }
  private String trim;
  public String get_trim() {
    return trim;
  }
  public void set_trim(String trim) {
    this.trim = trim;
  }
  public car_prices with_trim(String trim) {
    this.trim = trim;
    return this;
  }
  private String body;
  public String get_body() {
    return body;
  }
  public void set_body(String body) {
    this.body = body;
  }
  public car_prices with_body(String body) {
    this.body = body;
    return this;
  }
  private String transmission;
  public String get_transmission() {
    return transmission;
  }
  public void set_transmission(String transmission) {
    this.transmission = transmission;
  }
  public car_prices with_transmission(String transmission) {
    this.transmission = transmission;
    return this;
  }
  private String vin;
  public String get_vin() {
    return vin;
  }
  public void set_vin(String vin) {
    this.vin = vin;
  }
  public car_prices with_vin(String vin) {
    this.vin = vin;
    return this;
  }
  private String state;
  public String get_state() {
    return state;
  }
  public void set_state(String state) {
    this.state = state;
  }
  public car_prices with_state(String state) {
    this.state = state;
    return this;
  }
  private Integer condition;
  public Integer get_condition() {
    return condition;
  }
  public void set_condition(Integer condition) {
    this.condition = condition;
  }
  public car_prices with_condition(Integer condition) {
    this.condition = condition;
    return this;
  }
  private Integer odometer;
  public Integer get_odometer() {
    return odometer;
  }
  public void set_odometer(Integer odometer) {
    this.odometer = odometer;
  }
  public car_prices with_odometer(Integer odometer) {
    this.odometer = odometer;
    return this;
  }
  private String color;
  public String get_color() {
    return color;
  }
  public void set_color(String color) {
    this.color = color;
  }
  public car_prices with_color(String color) {
    this.color = color;
    return this;
  }
  private String interior;
  public String get_interior() {
    return interior;
  }
  public void set_interior(String interior) {
    this.interior = interior;
  }
  public car_prices with_interior(String interior) {
    this.interior = interior;
    return this;
  }
  private String seller;
  public String get_seller() {
    return seller;
  }
  public void set_seller(String seller) {
    this.seller = seller;
  }
  public car_prices with_seller(String seller) {
    this.seller = seller;
    return this;
  }
  private Integer mmr;
  public Integer get_mmr() {
    return mmr;
  }
  public void set_mmr(Integer mmr) {
    this.mmr = mmr;
  }
  public car_prices with_mmr(Integer mmr) {
    this.mmr = mmr;
    return this;
  }
  private Integer sellingprice;
  public Integer get_sellingprice() {
    return sellingprice;
  }
  public void set_sellingprice(Integer sellingprice) {
    this.sellingprice = sellingprice;
  }
  public car_prices with_sellingprice(Integer sellingprice) {
    this.sellingprice = sellingprice;
    return this;
  }
  private java.sql.Timestamp saledate;
  public java.sql.Timestamp get_saledate() {
    return saledate;
  }
  public void set_saledate(java.sql.Timestamp saledate) {
    this.saledate = saledate;
  }
  public car_prices with_saledate(java.sql.Timestamp saledate) {
    this.saledate = saledate;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof car_prices)) {
      return false;
    }
    car_prices that = (car_prices) o;
    boolean equal = true;
    equal = equal && (this.year == null ? that.year == null : this.year.equals(that.year));
    equal = equal && (this.make == null ? that.make == null : this.make.equals(that.make));
    equal = equal && (this.model == null ? that.model == null : this.model.equals(that.model));
    equal = equal && (this.trim == null ? that.trim == null : this.trim.equals(that.trim));
    equal = equal && (this.body == null ? that.body == null : this.body.equals(that.body));
    equal = equal && (this.transmission == null ? that.transmission == null : this.transmission.equals(that.transmission));
    equal = equal && (this.vin == null ? that.vin == null : this.vin.equals(that.vin));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.condition == null ? that.condition == null : this.condition.equals(that.condition));
    equal = equal && (this.odometer == null ? that.odometer == null : this.odometer.equals(that.odometer));
    equal = equal && (this.color == null ? that.color == null : this.color.equals(that.color));
    equal = equal && (this.interior == null ? that.interior == null : this.interior.equals(that.interior));
    equal = equal && (this.seller == null ? that.seller == null : this.seller.equals(that.seller));
    equal = equal && (this.mmr == null ? that.mmr == null : this.mmr.equals(that.mmr));
    equal = equal && (this.sellingprice == null ? that.sellingprice == null : this.sellingprice.equals(that.sellingprice));
    equal = equal && (this.saledate == null ? that.saledate == null : this.saledate.equals(that.saledate));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof car_prices)) {
      return false;
    }
    car_prices that = (car_prices) o;
    boolean equal = true;
    equal = equal && (this.year == null ? that.year == null : this.year.equals(that.year));
    equal = equal && (this.make == null ? that.make == null : this.make.equals(that.make));
    equal = equal && (this.model == null ? that.model == null : this.model.equals(that.model));
    equal = equal && (this.trim == null ? that.trim == null : this.trim.equals(that.trim));
    equal = equal && (this.body == null ? that.body == null : this.body.equals(that.body));
    equal = equal && (this.transmission == null ? that.transmission == null : this.transmission.equals(that.transmission));
    equal = equal && (this.vin == null ? that.vin == null : this.vin.equals(that.vin));
    equal = equal && (this.state == null ? that.state == null : this.state.equals(that.state));
    equal = equal && (this.condition == null ? that.condition == null : this.condition.equals(that.condition));
    equal = equal && (this.odometer == null ? that.odometer == null : this.odometer.equals(that.odometer));
    equal = equal && (this.color == null ? that.color == null : this.color.equals(that.color));
    equal = equal && (this.interior == null ? that.interior == null : this.interior.equals(that.interior));
    equal = equal && (this.seller == null ? that.seller == null : this.seller.equals(that.seller));
    equal = equal && (this.mmr == null ? that.mmr == null : this.mmr.equals(that.mmr));
    equal = equal && (this.sellingprice == null ? that.sellingprice == null : this.sellingprice.equals(that.sellingprice));
    equal = equal && (this.saledate == null ? that.saledate == null : this.saledate.equals(that.saledate));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.year = JdbcWritableBridge.readInteger(1, __dbResults);
    this.make = JdbcWritableBridge.readString(2, __dbResults);
    this.model = JdbcWritableBridge.readString(3, __dbResults);
    this.trim = JdbcWritableBridge.readString(4, __dbResults);
    this.body = JdbcWritableBridge.readString(5, __dbResults);
    this.transmission = JdbcWritableBridge.readString(6, __dbResults);
    this.vin = JdbcWritableBridge.readString(7, __dbResults);
    this.state = JdbcWritableBridge.readString(8, __dbResults);
    this.condition = JdbcWritableBridge.readInteger(9, __dbResults);
    this.odometer = JdbcWritableBridge.readInteger(10, __dbResults);
    this.color = JdbcWritableBridge.readString(11, __dbResults);
    this.interior = JdbcWritableBridge.readString(12, __dbResults);
    this.seller = JdbcWritableBridge.readString(13, __dbResults);
    this.mmr = JdbcWritableBridge.readInteger(14, __dbResults);
    this.sellingprice = JdbcWritableBridge.readInteger(15, __dbResults);
    this.saledate = JdbcWritableBridge.readTimestamp(16, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.year = JdbcWritableBridge.readInteger(1, __dbResults);
    this.make = JdbcWritableBridge.readString(2, __dbResults);
    this.model = JdbcWritableBridge.readString(3, __dbResults);
    this.trim = JdbcWritableBridge.readString(4, __dbResults);
    this.body = JdbcWritableBridge.readString(5, __dbResults);
    this.transmission = JdbcWritableBridge.readString(6, __dbResults);
    this.vin = JdbcWritableBridge.readString(7, __dbResults);
    this.state = JdbcWritableBridge.readString(8, __dbResults);
    this.condition = JdbcWritableBridge.readInteger(9, __dbResults);
    this.odometer = JdbcWritableBridge.readInteger(10, __dbResults);
    this.color = JdbcWritableBridge.readString(11, __dbResults);
    this.interior = JdbcWritableBridge.readString(12, __dbResults);
    this.seller = JdbcWritableBridge.readString(13, __dbResults);
    this.mmr = JdbcWritableBridge.readInteger(14, __dbResults);
    this.sellingprice = JdbcWritableBridge.readInteger(15, __dbResults);
    this.saledate = JdbcWritableBridge.readTimestamp(16, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(year, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(make, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(model, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(trim, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(body, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(transmission, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(vin, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(condition, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(odometer, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(color, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(interior, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(seller, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(mmr, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(sellingprice, 15 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(saledate, 16 + __off, 93, __dbStmt);
    return 16;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(year, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(make, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(model, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(trim, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(body, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(transmission, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(vin, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(state, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(condition, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(odometer, 10 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(color, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(interior, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(seller, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(mmr, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(sellingprice, 15 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(saledate, 16 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.year = null;
    } else {
    this.year = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.make = null;
    } else {
    this.make = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.model = null;
    } else {
    this.model = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.trim = null;
    } else {
    this.trim = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.body = null;
    } else {
    this.body = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.transmission = null;
    } else {
    this.transmission = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.vin = null;
    } else {
    this.vin = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.state = null;
    } else {
    this.state = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.condition = null;
    } else {
    this.condition = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.odometer = null;
    } else {
    this.odometer = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.color = null;
    } else {
    this.color = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.interior = null;
    } else {
    this.interior = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.seller = null;
    } else {
    this.seller = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.mmr = null;
    } else {
    this.mmr = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.sellingprice = null;
    } else {
    this.sellingprice = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.saledate = null;
    } else {
    this.saledate = new Timestamp(__dataIn.readLong());
    this.saledate.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.year) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.year);
    }
    if (null == this.make) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, make);
    }
    if (null == this.model) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, model);
    }
    if (null == this.trim) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, trim);
    }
    if (null == this.body) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, body);
    }
    if (null == this.transmission) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transmission);
    }
    if (null == this.vin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, vin);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.condition) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.condition);
    }
    if (null == this.odometer) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.odometer);
    }
    if (null == this.color) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, color);
    }
    if (null == this.interior) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, interior);
    }
    if (null == this.seller) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, seller);
    }
    if (null == this.mmr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.mmr);
    }
    if (null == this.sellingprice) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sellingprice);
    }
    if (null == this.saledate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.saledate.getTime());
    __dataOut.writeInt(this.saledate.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.year) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.year);
    }
    if (null == this.make) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, make);
    }
    if (null == this.model) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, model);
    }
    if (null == this.trim) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, trim);
    }
    if (null == this.body) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, body);
    }
    if (null == this.transmission) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, transmission);
    }
    if (null == this.vin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, vin);
    }
    if (null == this.state) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, state);
    }
    if (null == this.condition) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.condition);
    }
    if (null == this.odometer) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.odometer);
    }
    if (null == this.color) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, color);
    }
    if (null == this.interior) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, interior);
    }
    if (null == this.seller) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, seller);
    }
    if (null == this.mmr) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.mmr);
    }
    if (null == this.sellingprice) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.sellingprice);
    }
    if (null == this.saledate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.saledate.getTime());
    __dataOut.writeInt(this.saledate.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(year==null?"null":"" + year, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(make==null?"null":make, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(model==null?"null":model, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trim==null?"null":trim, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(body==null?"null":body, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transmission==null?"null":transmission, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vin==null?"null":vin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(condition==null?"null":"" + condition, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(odometer==null?"null":"" + odometer, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(color==null?"null":color, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(interior==null?"null":interior, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(seller==null?"null":seller, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mmr==null?"null":"" + mmr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sellingprice==null?"null":"" + sellingprice, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(saledate==null?"null":"" + saledate, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(year==null?"null":"" + year, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(make==null?"null":make, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(model==null?"null":model, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(trim==null?"null":trim, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(body==null?"null":body, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(transmission==null?"null":transmission, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(vin==null?"null":vin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(state==null?"null":state, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(condition==null?"null":"" + condition, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(odometer==null?"null":"" + odometer, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(color==null?"null":color, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(interior==null?"null":interior, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(seller==null?"null":seller, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(mmr==null?"null":"" + mmr, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sellingprice==null?"null":"" + sellingprice, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(saledate==null?"null":"" + saledate, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.year = null; } else {
      this.year = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.make = null; } else {
      this.make = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.model = null; } else {
      this.model = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.trim = null; } else {
      this.trim = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.body = null; } else {
      this.body = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transmission = null; } else {
      this.transmission = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.vin = null; } else {
      this.vin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.condition = null; } else {
      this.condition = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.odometer = null; } else {
      this.odometer = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.color = null; } else {
      this.color = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.interior = null; } else {
      this.interior = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.seller = null; } else {
      this.seller = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mmr = null; } else {
      this.mmr = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sellingprice = null; } else {
      this.sellingprice = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.saledate = null; } else {
      this.saledate = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.year = null; } else {
      this.year = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.make = null; } else {
      this.make = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.model = null; } else {
      this.model = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.trim = null; } else {
      this.trim = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.body = null; } else {
      this.body = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.transmission = null; } else {
      this.transmission = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.vin = null; } else {
      this.vin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.state = null; } else {
      this.state = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.condition = null; } else {
      this.condition = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.odometer = null; } else {
      this.odometer = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.color = null; } else {
      this.color = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.interior = null; } else {
      this.interior = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.seller = null; } else {
      this.seller = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.mmr = null; } else {
      this.mmr = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.sellingprice = null; } else {
      this.sellingprice = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.saledate = null; } else {
      this.saledate = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    car_prices o = (car_prices) super.clone();
    o.saledate = (o.saledate != null) ? (java.sql.Timestamp) o.saledate.clone() : null;
    return o;
  }

  public void clone0(car_prices o) throws CloneNotSupportedException {
    o.saledate = (o.saledate != null) ? (java.sql.Timestamp) o.saledate.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("year", this.year);
    __sqoop$field_map.put("make", this.make);
    __sqoop$field_map.put("model", this.model);
    __sqoop$field_map.put("trim", this.trim);
    __sqoop$field_map.put("body", this.body);
    __sqoop$field_map.put("transmission", this.transmission);
    __sqoop$field_map.put("vin", this.vin);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("condition", this.condition);
    __sqoop$field_map.put("odometer", this.odometer);
    __sqoop$field_map.put("color", this.color);
    __sqoop$field_map.put("interior", this.interior);
    __sqoop$field_map.put("seller", this.seller);
    __sqoop$field_map.put("mmr", this.mmr);
    __sqoop$field_map.put("sellingprice", this.sellingprice);
    __sqoop$field_map.put("saledate", this.saledate);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("year", this.year);
    __sqoop$field_map.put("make", this.make);
    __sqoop$field_map.put("model", this.model);
    __sqoop$field_map.put("trim", this.trim);
    __sqoop$field_map.put("body", this.body);
    __sqoop$field_map.put("transmission", this.transmission);
    __sqoop$field_map.put("vin", this.vin);
    __sqoop$field_map.put("state", this.state);
    __sqoop$field_map.put("condition", this.condition);
    __sqoop$field_map.put("odometer", this.odometer);
    __sqoop$field_map.put("color", this.color);
    __sqoop$field_map.put("interior", this.interior);
    __sqoop$field_map.put("seller", this.seller);
    __sqoop$field_map.put("mmr", this.mmr);
    __sqoop$field_map.put("sellingprice", this.sellingprice);
    __sqoop$field_map.put("saledate", this.saledate);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
