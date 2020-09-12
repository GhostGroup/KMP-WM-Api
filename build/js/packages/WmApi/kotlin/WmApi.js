(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'ktor-ktor-client-core-jsLegacy', 'kotlinx-serialization-kotlinx-serialization-core-jsLegacy'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('ktor-ktor-client-core-jsLegacy'), require('kotlinx-serialization-kotlinx-serialization-core-jsLegacy'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'WmApi'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'WmApi'.");
    }if (typeof this['ktor-ktor-client-core-jsLegacy'] === 'undefined') {
      throw new Error("Error loading module 'WmApi'. Its dependency 'ktor-ktor-client-core-jsLegacy' was not found. Please, check whether 'ktor-ktor-client-core-jsLegacy' is loaded prior to 'WmApi'.");
    }if (typeof this['kotlinx-serialization-kotlinx-serialization-core-jsLegacy'] === 'undefined') {
      throw new Error("Error loading module 'WmApi'. Its dependency 'kotlinx-serialization-kotlinx-serialization-core-jsLegacy' was not found. Please, check whether 'kotlinx-serialization-kotlinx-serialization-core-jsLegacy' is loaded prior to 'WmApi'.");
    }root.WmApi = factory(typeof WmApi === 'undefined' ? {} : WmApi, kotlin, this['ktor-ktor-client-core-jsLegacy'], this['kotlinx-serialization-kotlinx-serialization-core-jsLegacy']);
  }
}(this, function (_, Kotlin, $module$ktor_ktor_client_core_jsLegacy, $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var COROUTINE_SUSPENDED = Kotlin.kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED;
  var CoroutineImpl = Kotlin.kotlin.coroutines.CoroutineImpl;
  var HttpClient = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.HttpClient_f0veat$;
  var HttpResponse = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.statement.HttpResponse;
  var getKClass = Kotlin.getKClass;
  var createKType = Kotlin.createKType;
  var Unit = Kotlin.kotlin.Unit;
  var Json = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.json.Json_x26noe$;
  var readText = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.statement.readText_rjorc7$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var takeFrom = $module$ktor_ktor_client_core_jsLegacy.$$importsForInline$$['ktor-ktor-http-jsLegacy'].io.ktor.http.takeFrom_jl1sg7$;
  var utils = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.utils;
  var url = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.request.url_3rzbk2$;
  var HttpMethod = $module$ktor_ktor_client_core_jsLegacy.$$importsForInline$$['ktor-ktor-http-jsLegacy'].io.ktor.http.HttpMethod;
  var HttpRequestBuilder_init = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.request.HttpRequestBuilder;
  var HttpStatement_init = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.statement.HttpStatement;
  var throwCCE = Kotlin.throwCCE;
  var equals = Kotlin.equals;
  var complete = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.statement.complete_abn2de$;
  var call = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.call;
  var TypeInfo_init = $module$ktor_ktor_client_core_jsLegacy.io.ktor.client.call.TypeInfo;
  var serializer = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.serializer_ca95z9$;
  var KSerializer = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.KSerializer;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var PluginGeneratedSerialDescriptor = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
  var UnknownFieldException = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.UnknownFieldException;
  var GeneratedSerializer = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.internal.GeneratedSerializer;
  var MissingFieldException = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.MissingFieldException;
  var ArrayListSerializer = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.internal.ArrayListSerializer;
  var internal = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy.kotlinx.serialization.internal;
  function get$lambda($receiver) {
    return Unit;
  }
  function HelloWorld() {
  }
  function HelloWorld$getCarouselAds$lambda($receiver) {
    $receiver.ignoreUnknownKeys = true;
    return Unit;
  }
  function Coroutine$getCarouselAds_61zpoe$($this, regionId_0, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 6;
    this.$this = $this;
    this.local$response = void 0;
    this.local$format = void 0;
    this.local$regionId = regionId_0;
  }
  Coroutine$getCarouselAds_61zpoe$.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$getCarouselAds_61zpoe$.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$getCarouselAds_61zpoe$.prototype.constructor = Coroutine$getCarouselAds_61zpoe$;
  Coroutine$getCarouselAds_61zpoe$.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            var url_0 = 'https://api-g.weedmaps.com/discovery/v2/homepage?include[]=carousel&region_id=' + this.local$regionId;
            var client = HttpClient();
            var host_0;
            var body_0;
            host_0 = 'localhost';
            body_0 = utils.EmptyContent;
            var $receiver_1 = new HttpRequestBuilder_init();
            url($receiver_1, 'http', host_0, 0, '/');
            $receiver_1.method = HttpMethod.Companion.Get;
            $receiver_1.body = body_0;
            takeFrom($receiver_1.url, url_0);
            get$lambda($receiver_1);
            var $this_0 = new HttpStatement_init($receiver_1, client);
            var tmp$_4, tmp$_5, tmp$_6;
            tmp$_4 = getKClass(HttpResponse);
            if (equals(tmp$_4, getKClass(HttpStatement_init))) {
              this.result_0 = Kotlin.isType(tmp$_5 = $this_0, HttpResponse) ? tmp$_5 : throwCCE();
              this.state_0 = 9;
              continue;
            } else {
              if (equals(tmp$_4, getKClass(HttpResponse))) {
                this.state_0 = 7;
                this.result_0 = $this_0.execute(this);
                if (this.result_0 === COROUTINE_SUSPENDED)
                  return COROUTINE_SUSPENDED;
                continue;
              } else {
                this.state_0 = 1;
                this.result_0 = $this_0.executeUnsafe(this);
                if (this.result_0 === COROUTINE_SUSPENDED)
                  return COROUTINE_SUSPENDED;
                continue;
              }
            }

          case 1:
            this.local$response = this.result_0;
            this.exceptionState_0 = 4;
            var tmp$_7;
            var tmp$_8 = this.local$response.call;
            var typeInfo$result_0;
            typeInfo$break: do {
              try {
                typeInfo$result_0 = new TypeInfo_init(getKClass(HttpResponse), call.JsType, createKType(getKClass(HttpResponse), [], false));
              } catch (_) {
                typeInfo$result_0 = new TypeInfo_init(getKClass(HttpResponse), call.JsType);
                break typeInfo$break;
              }
            }
             while (false);
            this.state_0 = 2;
            this.result_0 = tmp$_8.receive_jo9acv$(typeInfo$result_0, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 2:
            this.result_0 = Kotlin.isType(tmp$_7 = this.result_0, HttpResponse) ? tmp$_7 : throwCCE();
            this.exceptionState_0 = 6;
            this.finallyPath_0 = [3];
            this.state_0 = 5;
            continue;
          case 3:
            this.state_0 = 8;
            continue;
          case 4:
            this.finallyPath_0 = [6];
            this.state_0 = 5;
            continue;
          case 5:
            this.exceptionState_0 = 6;
            complete(this.local$response);
            this.state_0 = this.finallyPath_0.shift();
            continue;
          case 6:
            throw this.exception_0;
          case 7:
            this.result_0 = Kotlin.isType(tmp$_6 = this.result_0, HttpResponse) ? tmp$_6 : throwCCE();
            this.state_0 = 8;
            continue;
          case 8:
            this.state_0 = 9;
            continue;
          case 9:
            this.result_0;
            var httpResponse = this.result_0;
            this.local$format = Json(void 0, HelloWorld$getCarouselAds$lambda);
            this.state_0 = 10;
            this.result_0 = readText(httpResponse, void 0, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 10:
            var string = this.result_0;
            var tmp$;
            return this.local$format.decodeFromString_awif5v$(Kotlin.isType(tmp$ = serializer(this.local$format.serializersModule, createKType(getKClass(HomescreenCarouselResponse), [], true)), KSerializer) ? tmp$ : throwCCE(), string);
          default:this.state_0 = 6;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 6) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  HelloWorld.prototype.getCarouselAds_61zpoe$ = function (regionId_0, continuation_0, suspended) {
    var instance = new Coroutine$getCarouselAds_61zpoe$(this, regionId_0, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  };
  HelloWorld.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'HelloWorld',
    interfaces: []
  };
  function HomescreenCarouselResponse(data) {
    HomescreenCarouselResponse$Companion_getInstance();
    this.data = data;
  }
  function HomescreenCarouselResponse$Companion() {
    HomescreenCarouselResponse$Companion_instance = this;
  }
  HomescreenCarouselResponse$Companion.prototype.serializer = function () {
    return HomescreenCarouselResponse$$serializer_getInstance();
  };
  HomescreenCarouselResponse$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var HomescreenCarouselResponse$Companion_instance = null;
  function HomescreenCarouselResponse$Companion_getInstance() {
    if (HomescreenCarouselResponse$Companion_instance === null) {
      new HomescreenCarouselResponse$Companion();
    }return HomescreenCarouselResponse$Companion_instance;
  }
  function HomescreenCarouselResponse$$serializer() {
    this.descriptor_8qbgd1$_0 = new PluginGeneratedSerialDescriptor('models.HomescreenCarouselResponse', this, 1);
    this.descriptor.addElement_ivxn3r$('data', false);
    HomescreenCarouselResponse$$serializer_instance = this;
  }
  Object.defineProperty(HomescreenCarouselResponse$$serializer.prototype, 'descriptor', {
    configurable: true,
    get: function () {
      return this.descriptor_8qbgd1$_0;
    }
  });
  HomescreenCarouselResponse$$serializer.prototype.serialize_55azsf$ = function (encoder, value) {
    var output = encoder.beginStructure_24f42q$(this.descriptor);
    output.encodeSerializableElement_r4qlx7$(this.descriptor, 0, Data$$serializer_getInstance(), value.data);
    output.endStructure_24f42q$(this.descriptor);
  };
  HomescreenCarouselResponse$$serializer.prototype.deserialize_bq71mq$ = function (decoder) {
    var index;
    var bitMask0 = 0;
    var local0;
    var input = decoder.beginStructure_24f42q$(this.descriptor);
    loopLabel: while (true) {
      index = input.decodeElementIndex_24f42q$(this.descriptor);
      switch (index) {
        case 0:
          local0 = input.decodeSerializableElement_12e8id$(this.descriptor, 0, Data$$serializer_getInstance(), local0);
          bitMask0 |= 1;
          break;
        case -1:
          break loopLabel;
        default:throw new UnknownFieldException(index);
      }
    }
    input.endStructure_24f42q$(this.descriptor);
    return HomescreenCarouselResponse_init(bitMask0, local0, null);
  };
  HomescreenCarouselResponse$$serializer.prototype.childSerializers = function () {
    return [Data$$serializer_getInstance()];
  };
  HomescreenCarouselResponse$$serializer.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: '$serializer',
    interfaces: [GeneratedSerializer]
  };
  var HomescreenCarouselResponse$$serializer_instance = null;
  function HomescreenCarouselResponse$$serializer_getInstance() {
    if (HomescreenCarouselResponse$$serializer_instance === null) {
      new HomescreenCarouselResponse$$serializer();
    }return HomescreenCarouselResponse$$serializer_instance;
  }
  function HomescreenCarouselResponse_init(seen1, data, serializationConstructorMarker) {
    var $this = serializationConstructorMarker || Object.create(HomescreenCarouselResponse.prototype);
    if ((seen1 & 1) === 0)
      throw new MissingFieldException('data');
    else
      $this.data = data;
    return $this;
  }
  HomescreenCarouselResponse.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'HomescreenCarouselResponse',
    interfaces: []
  };
  HomescreenCarouselResponse.prototype.component1 = function () {
    return this.data;
  };
  HomescreenCarouselResponse.prototype.copy_m59p72$ = function (data) {
    return new HomescreenCarouselResponse(data === void 0 ? this.data : data);
  };
  HomescreenCarouselResponse.prototype.toString = function () {
    return 'HomescreenCarouselResponse(data=' + Kotlin.toString(this.data) + ')';
  };
  HomescreenCarouselResponse.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.data) | 0;
    return result;
  };
  HomescreenCarouselResponse.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.data, other.data))));
  };
  function Data(carousel) {
    Data$Companion_getInstance();
    this.carousel = carousel;
  }
  function Data$Companion() {
    Data$Companion_instance = this;
  }
  Data$Companion.prototype.serializer = function () {
    return Data$$serializer_getInstance();
  };
  Data$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var Data$Companion_instance = null;
  function Data$Companion_getInstance() {
    if (Data$Companion_instance === null) {
      new Data$Companion();
    }return Data$Companion_instance;
  }
  function Data$$serializer() {
    this.descriptor_86679v$_0 = new PluginGeneratedSerialDescriptor('models.Data', this, 1);
    this.descriptor.addElement_ivxn3r$('carousel', false);
    Data$$serializer_instance = this;
  }
  Object.defineProperty(Data$$serializer.prototype, 'descriptor', {
    configurable: true,
    get: function () {
      return this.descriptor_86679v$_0;
    }
  });
  Data$$serializer.prototype.serialize_55azsf$ = function (encoder, value) {
    var output = encoder.beginStructure_24f42q$(this.descriptor);
    output.encodeSerializableElement_r4qlx7$(this.descriptor, 0, new ArrayListSerializer(Carousel$$serializer_getInstance()), value.carousel);
    output.endStructure_24f42q$(this.descriptor);
  };
  Data$$serializer.prototype.deserialize_bq71mq$ = function (decoder) {
    var index;
    var bitMask0 = 0;
    var local0;
    var input = decoder.beginStructure_24f42q$(this.descriptor);
    loopLabel: while (true) {
      index = input.decodeElementIndex_24f42q$(this.descriptor);
      switch (index) {
        case 0:
          local0 = input.decodeSerializableElement_12e8id$(this.descriptor, 0, new ArrayListSerializer(Carousel$$serializer_getInstance()), local0);
          bitMask0 |= 1;
          break;
        case -1:
          break loopLabel;
        default:throw new UnknownFieldException(index);
      }
    }
    input.endStructure_24f42q$(this.descriptor);
    return Data_init(bitMask0, local0, null);
  };
  Data$$serializer.prototype.childSerializers = function () {
    return [new ArrayListSerializer(Carousel$$serializer_getInstance())];
  };
  Data$$serializer.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: '$serializer',
    interfaces: [GeneratedSerializer]
  };
  var Data$$serializer_instance = null;
  function Data$$serializer_getInstance() {
    if (Data$$serializer_instance === null) {
      new Data$$serializer();
    }return Data$$serializer_instance;
  }
  function Data_init(seen1, carousel, serializationConstructorMarker) {
    var $this = serializationConstructorMarker || Object.create(Data.prototype);
    if ((seen1 & 1) === 0)
      throw new MissingFieldException('carousel');
    else
      $this.carousel = carousel;
    return $this;
  }
  Data.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Data',
    interfaces: []
  };
  Data.prototype.component1 = function () {
    return this.carousel;
  };
  Data.prototype.copy_yja92l$ = function (carousel) {
    return new Data(carousel === void 0 ? this.carousel : carousel);
  };
  Data.prototype.toString = function () {
    return 'Data(carousel=' + Kotlin.toString(this.carousel) + ')';
  };
  Data.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.carousel) | 0;
    return result;
  };
  Data.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.carousel, other.carousel))));
  };
  function Carousel(click_url) {
    Carousel$Companion_getInstance();
    this.click_url = click_url;
  }
  function Carousel$Companion() {
    Carousel$Companion_instance = this;
  }
  Carousel$Companion.prototype.serializer = function () {
    return Carousel$$serializer_getInstance();
  };
  Carousel$Companion.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Companion',
    interfaces: []
  };
  var Carousel$Companion_instance = null;
  function Carousel$Companion_getInstance() {
    if (Carousel$Companion_instance === null) {
      new Carousel$Companion();
    }return Carousel$Companion_instance;
  }
  function Carousel$$serializer() {
    this.descriptor_pd7qbb$_0 = new PluginGeneratedSerialDescriptor('models.Carousel', this, 1);
    this.descriptor.addElement_ivxn3r$('click_url', false);
    Carousel$$serializer_instance = this;
  }
  Object.defineProperty(Carousel$$serializer.prototype, 'descriptor', {
    configurable: true,
    get: function () {
      return this.descriptor_pd7qbb$_0;
    }
  });
  Carousel$$serializer.prototype.serialize_55azsf$ = function (encoder, value) {
    var output = encoder.beginStructure_24f42q$(this.descriptor);
    output.encodeStringElement_iij8qq$(this.descriptor, 0, value.click_url);
    output.endStructure_24f42q$(this.descriptor);
  };
  Carousel$$serializer.prototype.deserialize_bq71mq$ = function (decoder) {
    var index;
    var bitMask0 = 0;
    var local0;
    var input = decoder.beginStructure_24f42q$(this.descriptor);
    loopLabel: while (true) {
      index = input.decodeElementIndex_24f42q$(this.descriptor);
      switch (index) {
        case 0:
          local0 = input.decodeStringElement_szpzho$(this.descriptor, 0);
          bitMask0 |= 1;
          break;
        case -1:
          break loopLabel;
        default:throw new UnknownFieldException(index);
      }
    }
    input.endStructure_24f42q$(this.descriptor);
    return Carousel_init(bitMask0, local0, null);
  };
  Carousel$$serializer.prototype.childSerializers = function () {
    return [internal.StringSerializer];
  };
  Carousel$$serializer.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: '$serializer',
    interfaces: [GeneratedSerializer]
  };
  var Carousel$$serializer_instance = null;
  function Carousel$$serializer_getInstance() {
    if (Carousel$$serializer_instance === null) {
      new Carousel$$serializer();
    }return Carousel$$serializer_instance;
  }
  function Carousel_init(seen1, click_url, serializationConstructorMarker) {
    var $this = serializationConstructorMarker || Object.create(Carousel.prototype);
    if ((seen1 & 1) === 0)
      throw new MissingFieldException('click_url');
    else
      $this.click_url = click_url;
    return $this;
  }
  Carousel.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Carousel',
    interfaces: []
  };
  Carousel.prototype.component1 = function () {
    return this.click_url;
  };
  Carousel.prototype.copy_61zpoe$ = function (click_url) {
    return new Carousel(click_url === void 0 ? this.click_url : click_url);
  };
  Carousel.prototype.toString = function () {
    return 'Carousel(click_url=' + Kotlin.toString(this.click_url) + ')';
  };
  Carousel.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.click_url) | 0;
    return result;
  };
  Carousel.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.click_url, other.click_url))));
  };
  $$importsForInline$$['ktor-ktor-client-core-jsLegacy'] = $module$ktor_ktor_client_core_jsLegacy;
  $$importsForInline$$['kotlinx-serialization-kotlinx-serialization-core-jsLegacy'] = $module$kotlinx_serialization_kotlinx_serialization_core_jsLegacy;
  _.HelloWorld = HelloWorld;
  Object.defineProperty(HomescreenCarouselResponse, 'Companion', {
    get: HomescreenCarouselResponse$Companion_getInstance
  });
  Object.defineProperty(HomescreenCarouselResponse, '$serializer', {
    get: HomescreenCarouselResponse$$serializer_getInstance
  });
  var package$models = _.models || (_.models = {});
  package$models.HomescreenCarouselResponse_init_39dp68$ = HomescreenCarouselResponse_init;
  package$models.HomescreenCarouselResponse = HomescreenCarouselResponse;
  Object.defineProperty(Data, 'Companion', {
    get: Data$Companion_getInstance
  });
  Object.defineProperty(Data, '$serializer', {
    get: Data$$serializer_getInstance
  });
  package$models.Data_init_eimlv5$ = Data_init;
  package$models.Data = Data;
  Object.defineProperty(Carousel, 'Companion', {
    get: Carousel$Companion_getInstance
  });
  Object.defineProperty(Carousel, '$serializer', {
    get: Carousel$$serializer_getInstance
  });
  package$models.Carousel_init_q11ckg$ = Carousel_init;
  package$models.Carousel = Carousel;
  HomescreenCarouselResponse$$serializer.prototype.patch_h7kg3r$ = GeneratedSerializer.prototype.patch_h7kg3r$;
  HomescreenCarouselResponse$$serializer.prototype.typeParametersSerializers = GeneratedSerializer.prototype.typeParametersSerializers;
  Data$$serializer.prototype.patch_h7kg3r$ = GeneratedSerializer.prototype.patch_h7kg3r$;
  Data$$serializer.prototype.typeParametersSerializers = GeneratedSerializer.prototype.typeParametersSerializers;
  Carousel$$serializer.prototype.patch_h7kg3r$ = GeneratedSerializer.prototype.patch_h7kg3r$;
  Carousel$$serializer.prototype.typeParametersSerializers = GeneratedSerializer.prototype.typeParametersSerializers;
  Kotlin.defineModule('WmApi', _);
  return _;
}));

//# sourceMappingURL=WmApi.js.map
