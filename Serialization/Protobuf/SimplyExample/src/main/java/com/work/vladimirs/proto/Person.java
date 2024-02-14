// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

package com.work.vladimirs.proto;

/**
 * Protobuf type {@code protobuf.Person}
 */
public final class Person extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.Person)
    PersonOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Person.newBuilder() to construct.
  private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Person() {
    name_ = "";
    email_ = "";
    numbers_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Person();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return AddressBookProtos.internal_static_protobuf_Person_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return AddressBookProtos.internal_static_protobuf_Person_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Person.class, Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object name_ = "";
  /**
   * <code>required string name = 1;</code>
   * @return Whether the name field is set.
   */
  @Override
  public boolean hasName() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>required string name = 1;</code>
   * @return The name.
   */
  @Override
  public String getName() {
    Object ref = name_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        name_ = s;
      }
      return s;
    }
  }
  /**
   * <code>required string name = 1;</code>
   * @return The bytes for name.
   */
  @Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    Object ref = name_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 2;
  private int id_ = 0;
  /**
   * <code>required int32 id = 2;</code>
   * @return Whether the id field is set.
   */
  @Override
  public boolean hasId() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>required int32 id = 2;</code>
   * @return The id.
   */
  @Override
  public int getId() {
    return id_;
  }

  public static final int EMAIL_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile Object email_ = "";
  /**
   * <code>optional string email = 3;</code>
   * @return Whether the email field is set.
   */
  @Override
  public boolean hasEmail() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional string email = 3;</code>
   * @return The email.
   */
  @Override
  public String getEmail() {
    Object ref = email_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        email_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string email = 3;</code>
   * @return The bytes for email.
   */
  @Override
  public com.google.protobuf.ByteString
      getEmailBytes() {
    Object ref = email_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      email_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NUMBERS_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList numbers_ =
      com.google.protobuf.LazyStringArrayList.emptyList();
  /**
   * <code>repeated string numbers = 4;</code>
   * @return A list containing the numbers.
   */
  public com.google.protobuf.ProtocolStringList
      getNumbersList() {
    return numbers_;
  }
  /**
   * <code>repeated string numbers = 4;</code>
   * @return The count of numbers.
   */
  public int getNumbersCount() {
    return numbers_.size();
  }
  /**
   * <code>repeated string numbers = 4;</code>
   * @param index The index of the element to return.
   * @return The numbers at the given index.
   */
  public String getNumbers(int index) {
    return numbers_.get(index);
  }
  /**
   * <code>repeated string numbers = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the numbers at the given index.
   */
  public com.google.protobuf.ByteString
      getNumbersBytes(int index) {
    return numbers_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasName()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasId()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeInt32(2, id_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, email_);
    }
    for (int i = 0; i < numbers_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, numbers_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, id_);
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, email_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < numbers_.size(); i++) {
        dataSize += computeStringSizeNoTag(numbers_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getNumbersList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Person)) {
      return super.equals(obj);
    }
    Person other = (Person) obj;

    if (hasName() != other.hasName()) return false;
    if (hasName()) {
      if (!getName()
          .equals(other.getName())) return false;
    }
    if (hasId() != other.hasId()) return false;
    if (hasId()) {
      if (getId()
          != other.getId()) return false;
    }
    if (hasEmail() != other.hasEmail()) return false;
    if (hasEmail()) {
      if (!getEmail()
          .equals(other.getEmail())) return false;
    }
    if (!getNumbersList()
        .equals(other.getNumbersList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasName()) {
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
    }
    if (hasId()) {
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
    }
    if (hasEmail()) {
      hash = (37 * hash) + EMAIL_FIELD_NUMBER;
      hash = (53 * hash) + getEmail().hashCode();
    }
    if (getNumbersCount() > 0) {
      hash = (37 * hash) + NUMBERS_FIELD_NUMBER;
      hash = (53 * hash) + getNumbersList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Person parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Person parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Person parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Person parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Person parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static Person parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Person parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Person parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Person prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code protobuf.Person}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.Person)
      PersonOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return AddressBookProtos.internal_static_protobuf_Person_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return AddressBookProtos.internal_static_protobuf_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Person.class, Builder.class);
    }

    // Construct using com.work.vladimirs.proto.Person.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      name_ = "";
      id_ = 0;
      email_ = "";
      numbers_ =
          com.google.protobuf.LazyStringArrayList.emptyList();
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return AddressBookProtos.internal_static_protobuf_Person_descriptor;
    }

    @Override
    public Person getDefaultInstanceForType() {
      return Person.getDefaultInstance();
    }

    @Override
    public Person build() {
      Person result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Person buildPartial() {
      Person result = new Person(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(Person result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.id_ = id_;
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.email_ = email_;
        to_bitField0_ |= 0x00000004;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        numbers_.makeImmutable();
        result.numbers_ = numbers_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Person) {
        return mergeFrom((Person)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Person other) {
      if (other == Person.getDefaultInstance()) return this;
      if (other.hasName()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasId()) {
        setId(other.getId());
      }
      if (other.hasEmail()) {
        email_ = other.email_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.numbers_.isEmpty()) {
        if (numbers_.isEmpty()) {
          numbers_ = other.numbers_;
          bitField0_ |= 0x00000008;
        } else {
          ensureNumbersIsMutable();
          numbers_.addAll(other.numbers_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      if (!hasName()) {
        return false;
      }
      if (!hasId()) {
        return false;
      }
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              name_ = input.readBytes();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              id_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              email_ = input.readBytes();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              com.google.protobuf.ByteString bs = input.readBytes();
              ensureNumbersIsMutable();
              numbers_.add(bs);
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private Object name_ = "";
    /**
     * <code>required string name = 1;</code>
     * @return Whether the name field is set.
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>required string name = 1;</code>
     * @return The name.
     */
    public String getName() {
      Object ref = name_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>required string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>required string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>required string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>required string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int id_ ;
    /**
     * <code>required int32 id = 2;</code>
     * @return Whether the id field is set.
     */
    @Override
    public boolean hasId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>required int32 id = 2;</code>
     * @return The id.
     */
    @Override
    public int getId() {
      return id_;
    }
    /**
     * <code>required int32 id = 2;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {

      id_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>required int32 id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000002);
      id_ = 0;
      onChanged();
      return this;
    }

    private Object email_ = "";
    /**
     * <code>optional string email = 3;</code>
     * @return Whether the email field is set.
     */
    public boolean hasEmail() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional string email = 3;</code>
     * @return The email.
     */
    public String getEmail() {
      Object ref = email_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          email_ = s;
        }
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>optional string email = 3;</code>
     * @return The bytes for email.
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      Object ref = email_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string email = 3;</code>
     * @param value The email to set.
     * @return This builder for chaining.
     */
    public Builder setEmail(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      email_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional string email = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEmail() {
      email_ = getDefaultInstance().getEmail();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>optional string email = 3;</code>
     * @param value The bytes for email to set.
     * @return This builder for chaining.
     */
    public Builder setEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      email_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringArrayList numbers_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    private void ensureNumbersIsMutable() {
      if (!numbers_.isModifiable()) {
        numbers_ = new com.google.protobuf.LazyStringArrayList(numbers_);
      }
      bitField0_ |= 0x00000008;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @return A list containing the numbers.
     */
    public com.google.protobuf.ProtocolStringList
        getNumbersList() {
      numbers_.makeImmutable();
      return numbers_;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @return The count of numbers.
     */
    public int getNumbersCount() {
      return numbers_.size();
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param index The index of the element to return.
     * @return The numbers at the given index.
     */
    public String getNumbers(int index) {
      return numbers_.get(index);
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param index The index of the value to return.
     * @return The bytes of the numbers at the given index.
     */
    public com.google.protobuf.ByteString
        getNumbersBytes(int index) {
      return numbers_.getByteString(index);
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param index The index to set the value at.
     * @param value The numbers to set.
     * @return This builder for chaining.
     */
    public Builder setNumbers(
        int index, String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureNumbersIsMutable();
      numbers_.set(index, value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param value The numbers to add.
     * @return This builder for chaining.
     */
    public Builder addNumbers(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureNumbersIsMutable();
      numbers_.add(value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param values The numbers to add.
     * @return This builder for chaining.
     */
    public Builder addAllNumbers(
        Iterable<String> values) {
      ensureNumbersIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, numbers_);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumbers() {
      numbers_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string numbers = 4;</code>
     * @param value The bytes of the numbers to add.
     * @return This builder for chaining.
     */
    public Builder addNumbersBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      ensureNumbersIsMutable();
      numbers_.add(value);
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:protobuf.Person)
  }

  // @@protoc_insertion_point(class_scope:protobuf.Person)
  private static final Person DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Person();
  }

  public static Person getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @Deprecated public static final com.google.protobuf.Parser<Person>
      PARSER = new com.google.protobuf.AbstractParser<Person>() {
    @Override
    public Person parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Person> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Person> getParserForType() {
    return PARSER;
  }

  @Override
  public Person getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
