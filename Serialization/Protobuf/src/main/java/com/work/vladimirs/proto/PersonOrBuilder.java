// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

package com.work.vladimirs.proto;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:protobuf.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>required string name = 1;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>required string name = 1;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>required string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>required int32 id = 2;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>required int32 id = 2;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>optional string email = 3;</code>
   * @return Whether the email field is set.
   */
  boolean hasEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The email.
   */
  String getEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>repeated string numbers = 4;</code>
   * @return A list containing the numbers.
   */
  java.util.List<String>
      getNumbersList();
  /**
   * <code>repeated string numbers = 4;</code>
   * @return The count of numbers.
   */
  int getNumbersCount();
  /**
   * <code>repeated string numbers = 4;</code>
   * @param index The index of the element to return.
   * @return The numbers at the given index.
   */
  String getNumbers(int index);
  /**
   * <code>repeated string numbers = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the numbers at the given index.
   */
  com.google.protobuf.ByteString
      getNumbersBytes(int index);
}
