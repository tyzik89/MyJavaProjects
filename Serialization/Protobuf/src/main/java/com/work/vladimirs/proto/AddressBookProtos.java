// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addressbook.proto

package com.work.vladimirs.proto;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_AddressBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_AddressBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\021addressbook.proto\022\010protobuf\"B\n\006Person\022" +
      "\014\n\004name\030\001 \002(\t\022\n\n\002id\030\002 \002(\005\022\r\n\005email\030\003 \001(\t" +
      "\022\017\n\007numbers\030\004 \003(\t\"/\n\013AddressBook\022 \n\006peop" +
      "le\030\001 \003(\0132\020.protobuf.PersonB/\n\030com.work.v" +
      "ladimirs.protoB\021AddressBookProtosP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_protobuf_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protobuf_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_Person_descriptor,
        new String[] { "Name", "Id", "Email", "Numbers", });
    internal_static_protobuf_AddressBook_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_protobuf_AddressBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_AddressBook_descriptor,
        new String[] { "People", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
