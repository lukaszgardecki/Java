! function(t) {
    if ("object" == typeof exports && "undefined" != typeof module) module.exports = t();
    else if ("function" == typeof define && define.amd) define([], t);
    else {
        var e;
        e = "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : this, e.SockJS = t()
    }
}(function() {
    var t;
    return function t(e, n, r) {
        function i(s, a) {
            if (!n[s]) {
                if (!e[s]) {
                    var l = "function" == typeof require && require;
                    if (!a && l) return l(s, !0);
                    if (o) return o(s, !0);
                    var u = new Error("Cannot find module '" + s + "'");
                    throw u.code = "MODULE_NOT_FOUND", u
                }
                var c = n[s] = {
                    exports: {}
                };
                e[s][0].call(c.exports, function(t) {
                    var n = e[s][1][t];
                    return i(n || t)
                }, c, c.exports, t, e, n, r)
            }
            return n[s].exports
        }
        for (var o = "function" == typeof require && require, s = 0; s < r.length; s++) i(r[s]);
        return i
    }({
        1: [function(t, e, n) {
            (function(n) {
                "use strict";
                var r = t("./transport-list");
                e.exports = t("./main")(r), "_sockjs_onload" in n && setTimeout(n._sockjs_onload, 1)
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./main": 14,
            "./transport-list": 16
        }],
        2: [function(t, e, n) {
            "use strict";

            function r() {
                o.call(this), this.initEvent("close", !1, !1), this.wasClean = !1, this.code = 0, this.reason = ""
            }
            var i = t("inherits"),
                o = t("./event");
            i(r, o), e.exports = r
        }, {
            "./event": 4,
            "inherits": 54
        }],
        3: [function(t, e, n) {
            "use strict";

            function r() {
                o.call(this)
            }
            var i = t("inherits"),
                o = t("./eventtarget");
            i(r, o), r.prototype.removeAllListeners = function(t) {
                t ? delete this._listeners[t] : this._listeners = {}
            }, r.prototype.once = function(t, e) {
                function n() {
                    r.removeListener(t, n), i || (i = !0, e.apply(this, arguments))
                }
                var r = this,
                    i = !1;
                this.on(t, n)
            }, r.prototype.emit = function() {
                var t = arguments[0],
                    e = this._listeners[t];
                if (e) {
                    for (var n = arguments.length, r = new Array(n - 1), i = 1; i < n; i++) r[i - 1] = arguments[i];
                    for (var o = 0; o < e.length; o++) e[o].apply(this, r)
                }
            }, r.prototype.on = r.prototype.addListener = o.prototype.addEventListener, r.prototype.removeListener = o.prototype.removeEventListener, e.exports.EventEmitter = r
        }, {
            "./eventtarget": 5,
            "inherits": 54
        }],
        4: [function(t, e, n) {
            "use strict";

            function r(t) {
                this.type = t
            }
            r.prototype.initEvent = function(t, e, n) {
                return this.type = t, this.bubbles = e, this.cancelable = n, this.timeStamp = +new Date, this
            }, r.prototype.stopPropagation = function() {}, r.prototype.preventDefault = function() {}, r.CAPTURING_PHASE = 1, r.AT_TARGET = 2, r.BUBBLING_PHASE = 3, e.exports = r
        }, {}],
        5: [function(t, e, n) {
            "use strict";

            function r() {
                this._listeners = {}
            }
            r.prototype.addEventListener = function(t, e) {
                t in this._listeners || (this._listeners[t] = []);
                var n = this._listeners[t]; - 1 === n.indexOf(e) && (n = n.concat([e])), this._listeners[t] = n
            }, r.prototype.removeEventListener = function(t, e) {
                var n = this._listeners[t];
                if (n) {
                    var r = n.indexOf(e);
                    return -1 !== r ? void(n.length > 1 ? this._listeners[t] = n.slice(0, r).concat(n.slice(r + 1)) : delete this._listeners[t]) : void 0
                }
            }, r.prototype.dispatchEvent = function() {
                var t = arguments[0],
                    e = t.type,
                    n = 1 === arguments.length ? [t] : Array.apply(null, arguments);
                if (this["on" + e] && this["on" + e].apply(this, n), e in this._listeners)
                    for (var r = this._listeners[e], i = 0; i < r.length; i++) r[i].apply(this, n)
            }, e.exports = r
        }, {}],
        6: [function(t, e, n) {
            "use strict";

            function r(t) {
                o.call(this), this.initEvent("message", !1, !1), this.data = t
            }
            var i = t("inherits"),
                o = t("./event");
            i(r, o), e.exports = r
        }, {
            "./event": 4,
            "inherits": 54
        }],
        7: [function(t, e, n) {
            "use strict";

            function r(t) {
                this._transport = t, t.on("message", this._transportMessage.bind(this)), t.on("close", this._transportClose.bind(this))
            }
            var i = t("json3"),
                o = t("./utils/iframe");
            r.prototype._transportClose = function(t, e) {
                o.postMessage("c", i.stringify([t, e]))
            }, r.prototype._transportMessage = function(t) {
                o.postMessage("t", t)
            }, r.prototype._send = function(t) {
                this._transport.send(t)
            }, r.prototype._close = function() {
                this._transport.close(), this._transport.removeAllListeners()
            }, e.exports = r
        }, {
            "./utils/iframe": 47,
            "json3": 55
        }],
        8: [function(t, e, n) {
            "use strict";
            var r = t("./utils/url"),
                i = t("./utils/event"),
                o = t("json3"),
                s = t("./facade"),
                a = t("./info-iframe-receiver"),
                l = t("./utils/iframe"),
                u = t("./location");
            e.exports = function(t, e) {
                var n = {};
                e.forEach(function(t) {
                    t.facadeTransport && (n[t.facadeTransport.transportName] = t.facadeTransport)
                }), n[a.transportName] = a;
                var c;
                t.bootstrap_iframe = function() {
                    var e;
                    l.currentWindowId = u.hash.slice(1);
                    var a = function(i) {
                        if (i.source === parent && (void 0 === c && (c = i.origin), i.origin === c)) {
                            var a;
                            try {
                                a = o.parse(i.data)
                            } catch (t) {
                                return void i.data
                            }
                            if (a.windowId === l.currentWindowId) switch (a.type) {
                                case "s":
                                    var f;
                                    try {
                                        f = o.parse(a.data)
                                    } catch (t) {
                                        a.data;
                                        break
                                    }
                                    var h = f[0],
                                        d = f[1],
                                        p = f[2],
                                        v = f[3];
                                    if (h !== t.version) throw new Error('Incompatible SockJS! Main site uses: "' + h + '", the iframe: "' + t.version + '".');
                                    if (!r.isOriginEqual(p, u.href) || !r.isOriginEqual(v, u.href)) throw new Error("Can't connect to different domain from within an iframe. (" + u.href + ", " + p + ", " + v + ")");
                                    e = new s(new n[d](p, v));
                                    break;
                                case "m":
                                    e._send(a.data);
                                    break;
                                case "c":
                                    e && e._close(), e = null
                            }
                        }
                    };
                    i.attachEvent("message", a), l.postMessage("s")
                }
            }
        }, {
            "./facade": 7,
            "./info-iframe-receiver": 10,
            "./location": 13,
            "./utils/event": 46,
            "./utils/iframe": 47,
            "./utils/url": 52,
            "debug": void 0,
            "json3": 55
        }],
        9: [function(t, e, n) {
            "use strict";

            function r(t, e) {
                i.call(this);
                var n = this,
                    r = +new Date;
                this.xo = new e("GET", t), this.xo.once("finish", function(t, e) {
                    var i, o;
                    if (200 === t) {
                        if (o = +new Date - r, e) try {
                            i = s.parse(e)
                        } catch (t) {}
                        a.isObject(i) || (i = {})
                    }
                    n.emit("finish", i, o), n.removeAllListeners()
                })
            }
            var i = t("events").EventEmitter,
                o = t("inherits"),
                s = t("json3"),
                a = t("./utils/object");
            o(r, i), r.prototype.close = function() {
                this.removeAllListeners(), this.xo.close()
            }, e.exports = r
        }, {
            "./utils/object": 49,
            "debug": void 0,
            "events": 3,
            "inherits": 54,
            "json3": 55
        }],
        10: [function(t, e, n) {
            "use strict";

            function r(t) {
                var e = this;
                o.call(this), this.ir = new l(t, a), this.ir.once("finish", function(t, n) {
                    e.ir = null, e.emit("message", s.stringify([t, n]))
                })
            }
            var i = t("inherits"),
                o = t("events").EventEmitter,
                s = t("json3"),
                a = t("./transport/sender/xhr-local"),
                l = t("./info-ajax");
            i(r, o), r.transportName = "iframe-info-receiver", r.prototype.close = function() {
                this.ir && (this.ir.close(), this.ir = null), this.removeAllListeners()
            }, e.exports = r
        }, {
            "./info-ajax": 9,
            "./transport/sender/xhr-local": 37,
            "events": 3,
            "inherits": 54,
            "json3": 55
        }],
        11: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t, e) {
                    var r = this;
                    i.call(this);
                    var o = function() {
                        var n = r.ifr = new l(u.transportName, e, t);
                        n.once("message", function(t) {
                            if (t) {
                                var e;
                                try {
                                    e = s.parse(t)
                                } catch (t) {
                                    return r.emit("finish"), void r.close()
                                }
                                var n = e[0],
                                    i = e[1];
                                r.emit("finish", n, i)
                            }
                            r.close()
                        }), n.once("close", function() {
                            r.emit("finish"), r.close()
                        })
                    };
                    n.document.body ? o() : a.attachEvent("load", o)
                }
                var i = t("events").EventEmitter,
                    o = t("inherits"),
                    s = t("json3"),
                    a = t("./utils/event"),
                    l = t("./transport/iframe"),
                    u = t("./info-iframe-receiver");
                o(r, i), r.enabled = function() {
                    return l.enabled()
                }, r.prototype.close = function() {
                    this.ifr && this.ifr.close(), this.removeAllListeners(), this.ifr = null
                }, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./info-iframe-receiver": 10,
            "./transport/iframe": 22,
            "./utils/event": 46,
            "debug": void 0,
            "events": 3,
            "inherits": 54,
            "json3": 55
        }],
        12: [function(t, e, n) {
            "use strict";

            function r(t, e) {
                var n = this;
                i.call(this), setTimeout(function() {
                    n.doXhr(t, e)
                }, 0)
            }
            var i = t("events").EventEmitter,
                o = t("inherits"),
                s = t("./utils/url"),
                a = t("./transport/sender/xdr"),
                l = t("./transport/sender/xhr-cors"),
                u = t("./transport/sender/xhr-local"),
                c = t("./transport/sender/xhr-fake"),
                f = t("./info-iframe"),
                h = t("./info-ajax");
            o(r, i), r._getReceiver = function(t, e, n) {
                return n.sameOrigin ? new h(e, u) : l.enabled ? new h(e, l) : a.enabled && n.sameScheme ? new h(e, a) : f.enabled() ? new f(t, e) : new h(e, c)
            }, r.prototype.doXhr = function(t, e) {
                var n = this,
                    i = s.addPath(t, "/info");
                this.xo = r._getReceiver(t, i, e), this.timeoutRef = setTimeout(function() {
                    n._cleanup(!1), n.emit("finish")
                }, r.timeout), this.xo.once("finish", function(t, e) {
                    n._cleanup(!0), n.emit("finish", t, e)
                })
            }, r.prototype._cleanup = function(t) {
                clearTimeout(this.timeoutRef), this.timeoutRef = null, !t && this.xo && this.xo.close(), this.xo = null
            }, r.prototype.close = function() {
                this.removeAllListeners(), this._cleanup(!1)
            }, r.timeout = 8e3, e.exports = r
        }, {
            "./info-ajax": 9,
            "./info-iframe": 11,
            "./transport/sender/xdr": 34,
            "./transport/sender/xhr-cors": 35,
            "./transport/sender/xhr-fake": 36,
            "./transport/sender/xhr-local": 37,
            "./utils/url": 52,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        13: [function(t, e, n) {
            (function(t) {
                "use strict";
                e.exports = t.location || {
                    origin: "http://localhost:80",
                    protocol: "http",
                    host: "localhost",
                    port: 80,
                    href: "http://localhost/",
                    hash: ""
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        14: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t, e, n) {
                    if (!(this instanceof r)) return new r(t, e, n);
                    if (arguments.length < 1) throw new TypeError("Failed to construct 'SockJS: 1 argument required, but only 0 present");
                    y.call(this), this.readyState = r.CONNECTING, this.extensions = "", this.protocol = "", n = n || {}, n.protocols_whitelist && m.warn("'protocols_whitelist' is DEPRECATED. Use 'transports' instead."), this._transportsWhitelist = n.transports, this._transportOptions = n.transportOptions || {};
                    var i = n.sessionId || 8;
                    if ("function" == typeof i) this._generateSessionId = i;
                    else {
                        if ("number" != typeof i) throw new TypeError("If sessionId is used in the options, it needs to be a number or a function.");
                        this._generateSessionId = function() {
                            return u.string(i)
                        }
                    }
                    this._server = n.server || u.numberString(1e3);
                    var o = new s(t);
                    if (!o.host || !o.protocol) throw new SyntaxError("The URL '" + t + "' is invalid");
                    if (o.hash) throw new SyntaxError("The URL must not contain a fragment");
                    if ("http:" !== o.protocol && "https:" !== o.protocol) throw new SyntaxError("The URL's scheme must be either 'http:' or 'https:'. '" + o.protocol + "' is not allowed.");
                    var a = "https:" === o.protocol;
                    if ("https" === g.protocol && !a) throw new Error("SecurityError: An insecure SockJS connection may not be initiated from a page loaded over HTTPS");
                    e ? Array.isArray(e) || (e = [e]) : e = [];
                    var l = e.sort();
                    l.forEach(function(t, e) {
                        if (!t) throw new SyntaxError("The protocols entry '" + t + "' is invalid.");
                        if (e < l.length - 1 && t === l[e + 1]) throw new SyntaxError("The protocols entry '" + t + "' is duplicated.")
                    });
                    var c = f.getOrigin(g.href);
                    this._origin = c ? c.toLowerCase() : null, o.set("pathname", o.pathname.replace(/\/+$/, "")), this.url = o.href, this.url, this._urlInfo = {
                        nullOrigin: !v.hasDomain(),
                        sameOrigin: f.isOriginEqual(this.url, g.href),
                        sameScheme: f.isSchemeEqual(this.url, g.href)
                    }, this._ir = new _(this.url, this._urlInfo), this._ir.once("finish", this._receiveInfo.bind(this))
                }

                function i(t) {
                    return 1e3 === t || t >= 3e3 && t <= 4999
                }
                t("./shims");
                var o, s = t("url-parse"),
                    a = t("inherits"),
                    l = t("json3"),
                    u = t("./utils/random"),
                    c = t("./utils/escape"),
                    f = t("./utils/url"),
                    h = t("./utils/event"),
                    d = t("./utils/transport"),
                    p = t("./utils/object"),
                    v = t("./utils/browser"),
                    m = t("./utils/log"),
                    b = t("./event/event"),
                    y = t("./event/eventtarget"),
                    g = t("./location"),
                    w = t("./event/close"),
                    x = t("./event/trans-message"),
                    _ = t("./info-receiver");
                a(r, y), r.prototype.close = function(t, e) {
                    if (t && !i(t)) throw new Error("InvalidAccessError: Invalid code");
                    if (e && e.length > 123) throw new SyntaxError("reason argument has an invalid length");
                    if (this.readyState !== r.CLOSING && this.readyState !== r.CLOSED) {
                        this._close(t || 1e3, e || "Normal closure", !0)
                    }
                }, r.prototype.send = function(t) {
                    if ("string" != typeof t && (t = "" + t), this.readyState === r.CONNECTING) throw new Error("InvalidStateError: The connection has not been established yet");
                    this.readyState === r.OPEN && this._transport.send(c.quote(t))
                }, r.version = t("./version"), r.CONNECTING = 0, r.OPEN = 1, r.CLOSING = 2, r.CLOSED = 3, r.prototype._receiveInfo = function(t, e) {
                    if (this._ir = null, !t) return void this._close(1002, "Cannot connect to server");
                    this._rto = this.countRTO(e), this._transUrl = t.base_url ? t.base_url : this.url, t = p.extend(t, this._urlInfo);
                    var n = o.filterToEnabled(this._transportsWhitelist, t);
                    this._transports = n.main, this._transports.length, this._connect()
                }, r.prototype._connect = function() {
                    for (var t = this._transports.shift(); t; t = this._transports.shift()) {
                        if (t.transportName, t.needBody && (!n.document.body || void 0 !== n.document.readyState && "complete" !== n.document.readyState && "interactive" !== n.document.readyState)) return this._transports.unshift(t), void h.attachEvent("load", this._connect.bind(this));
                        var e = this._rto * t.roundTrips || 5e3;
                        this._transportTimeoutId = setTimeout(this._transportTimeout.bind(this), e);
                        var r = f.addPath(this._transUrl, "/" + this._server + "/" + this._generateSessionId()),
                            i = this._transportOptions[t.transportName],
                            o = new t(r, this._transUrl, i);
                        return o.on("message", this._transportMessage.bind(this)), o.once("close", this._transportClose.bind(this)), o.transportName = t.transportName, void(this._transport = o)
                    }
                    this._close(2e3, "All transports failed", !1)
                }, r.prototype._transportTimeout = function() {
                    this.readyState === r.CONNECTING && this._transportClose(2007, "Transport timed out")
                }, r.prototype._transportMessage = function(t) {
                    var e, n = this,
                        r = t.slice(0, 1),
                        i = t.slice(1);
                    switch (r) {
                        case "o":
                            return void this._open();
                        case "h":
                            return this.dispatchEvent(new b("heartbeat")), void this.transport
                    }
                    if (i) try {
                        e = l.parse(i)
                    } catch (t) {}
                    if (void 0 !== e) switch (r) {
                        case "a":
                            Array.isArray(e) && e.forEach(function(t) {
                                n.transport, n.dispatchEvent(new x(t))
                            });
                            break;
                        case "m":
                            this.transport, this.dispatchEvent(new x(e));
                            break;
                        case "c":
                            Array.isArray(e) && 2 === e.length && this._close(e[0], e[1], !0)
                    }
                }, r.prototype._transportClose = function(t, e) {
                    if (this.transport, this._transport && (this._transport.removeAllListeners(), this._transport = null, this.transport = null), !i(t) && 2e3 !== t && this.readyState === r.CONNECTING) return void this._connect();
                    this._close(t, e)
                }, r.prototype._open = function() {
                    this._transport.transportName, this.readyState, this.readyState === r.CONNECTING ? (this._transportTimeoutId && (clearTimeout(this._transportTimeoutId), this._transportTimeoutId = null), this.readyState = r.OPEN, this.transport = this._transport.transportName, this.dispatchEvent(new b("open")), this.transport) : this._close(1006, "Server lost session")
                }, r.prototype._close = function(t, e, n) {
                    this.transport, this.readyState;
                    var i = !1;
                    if (this._ir && (i = !0, this._ir.close(), this._ir = null), this._transport && (this._transport.close(), this._transport = null, this.transport = null), this.readyState === r.CLOSED) throw new Error("InvalidStateError: SockJS has already been closed");
                    this.readyState = r.CLOSING, setTimeout(function() {
                        this.readyState = r.CLOSED, i && this.dispatchEvent(new b("error"));
                        var o = new w("close");
                        o.wasClean = n || !1, o.code = t || 1e3, o.reason = e, this.dispatchEvent(o), this.onmessage = this.onclose = this.onerror = null
                    }.bind(this), 0)
                }, r.prototype.countRTO = function(t) {
                    return t > 100 ? 4 * t : 300 + t
                }, e.exports = function(e) {
                    return o = d(e), t("./iframe-bootstrap")(r, e), r
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./event/close": 2,
            "./event/event": 4,
            "./event/eventtarget": 5,
            "./event/trans-message": 6,
            "./iframe-bootstrap": 8,
            "./info-receiver": 12,
            "./location": 13,
            "./shims": 15,
            "./utils/browser": 44,
            "./utils/escape": 45,
            "./utils/event": 46,
            "./utils/log": 48,
            "./utils/object": 49,
            "./utils/random": 50,
            "./utils/transport": 51,
            "./utils/url": 52,
            "./version": 53,
            "debug": void 0,
            "inherits": 54,
            "json3": 55,
            "url-parse": 58
        }],
        15: [function(t, e, n) {
            "use strict";

            function r(t) {
                var e = +t;
                return e !== e ? e = 0 : 0 !== e && e !== 1 / 0 && e !== -1 / 0 && (e = (e > 0 || -1) * Math.floor(Math.abs(e))), e
            }

            function i(t) {
                return t >>> 0
            }

            function o() {}
            var s, a = Array.prototype,
                l = Object.prototype,
                u = Function.prototype,
                c = String.prototype,
                f = a.slice,
                h = l.toString,
                d = function(t) {
                    return "[object Function]" === l.toString.call(t)
                },
                p = function(t) {
                    return "[object Array]" === h.call(t)
                },
                v = function(t) {
                    return "[object String]" === h.call(t)
                },
                m = Object.defineProperty && function() {
                    try {
                        return Object.defineProperty({}, "x", {}), !0
                    } catch (t) {
                        return !1
                    }
                }();
            s = m ? function(t, e, n, r) {
                !r && e in t || Object.defineProperty(t, e, {
                    configurable: !0,
                    enumerable: !1,
                    writable: !0,
                    value: n
                })
            } : function(t, e, n, r) {
                !r && e in t || (t[e] = n)
            };
            var b = function(t, e, n) {
                    for (var r in e) l.hasOwnProperty.call(e, r) && s(t, r, e[r], n)
                },
                y = function(t) {
                    if (null == t) throw new TypeError("can't convert " + t + " to object");
                    return Object(t)
                };
            b(u, {
                bind: function(t) {
                    var e = this;
                    if (!d(e)) throw new TypeError("Function.prototype.bind called on incompatible " + e);
                    for (var n = f.call(arguments, 1), r = function() {
                        if (this instanceof l) {
                            var r = e.apply(this, n.concat(f.call(arguments)));
                            return Object(r) === r ? r : this
                        }
                        return e.apply(t, n.concat(f.call(arguments)))
                    }, i = Math.max(0, e.length - n.length), s = [], a = 0; a < i; a++) s.push("$" + a);
                    var l = Function("binder", "return function (" + s.join(",") + "){ return binder.apply(this, arguments); }")(r);
                    return e.prototype && (o.prototype = e.prototype, l.prototype = new o, o.prototype = null), l
                }
            }), b(Array, {
                isArray: p
            });
            var g = Object("a"),
                w = "a" !== g[0] || !(0 in g);
            b(a, {
                forEach: function(t) {
                    var e = y(this),
                        n = w && v(this) ? this.split("") : e,
                        r = arguments[1],
                        i = -1,
                        o = n.length >>> 0;
                    if (!d(t)) throw new TypeError;
                    for (; ++i < o;) i in n && t.call(r, n[i], i, e)
                }
            }, ! function(t) {
                var e = !0,
                    n = !0;
                return t && (t.call("foo", function(t, n, r) {
                    "object" != typeof r && (e = !1)
                }), t.call([1], function() {
                    n = "string" == typeof this
                }, "x")), !!t && e && n
            }(a.forEach));
            var x = Array.prototype.indexOf && -1 !== [0, 1].indexOf(1, 2);
            b(a, {
                indexOf: function(t) {
                    var e = w && v(this) ? this.split("") : y(this),
                        n = e.length >>> 0;
                    if (!n) return -1;
                    var i = 0;
                    for (arguments.length > 1 && (i = r(arguments[1])), i = i >= 0 ? i : Math.max(0, n + i); i < n; i++)
                        if (i in e && e[i] === t) return i;
                    return -1
                }
            }, x);
            var _ = c.split;
            2 !== "ab".split(/(?:ab)*/).length || 4 !== ".".split(/(.?)(.?)/).length || "t" === "tesst".split(/(s)*/)[1] || 4 !== "test".split(/(?:)/, -1).length || "".split(/.?/).length || ".".split(/()()/).length > 1 ? function() {
                var t = void 0 === /()??/.exec("")[1];
                c.split = function(e, n) {
                    var r = this;
                    if (void 0 === e && 0 === n) return [];
                    if ("[object RegExp]" !== h.call(e)) return _.call(this, e, n);
                    var o, s, l, u, c = [],
                        f = (e.ignoreCase ? "i" : "") + (e.multiline ? "m" : "") + (e.extended ? "x" : "") + (e.sticky ? "y" : ""),
                        d = 0;
                    for (e = new RegExp(e.source, f + "g"), r += "", t || (o = new RegExp("^" + e.source + "$(?!\\s)", f)), n = void 0 === n ? -1 >>> 0 : i(n);
                         (s = e.exec(r)) && !((l = s.index + s[0].length) > d && (c.push(r.slice(d, s.index)), !t && s.length > 1 && s[0].replace(o, function() {
                             for (var t = 1; t < arguments.length - 2; t++) void 0 === arguments[t] && (s[t] = void 0)
                         }), s.length > 1 && s.index < r.length && a.push.apply(c, s.slice(1)), u = s[0].length, d = l, c.length >= n));) e.lastIndex === s.index && e.lastIndex++;
                    return d === r.length ? !u && e.test("") || c.push("") : c.push(r.slice(d)), c.length > n ? c.slice(0, n) : c
                }
            }() : "0".split(void 0, 0).length && (c.split = function(t, e) {
                return void 0 === t && 0 === e ? [] : _.call(this, t, e)
            });
            var E = c.substr,
                j = "".substr && "b" !== "0b".substr(-1);
            b(c, {
                substr: function(t, e) {
                    return E.call(this, t < 0 && (t = this.length + t) < 0 ? 0 : t, e)
                }
            }, j)
        }, {}],
        16: [function(t, e, n) {
            "use strict";
            e.exports = [t("./transport/websocket"), t("./transport/xhr-streaming"), t("./transport/xdr-streaming"), t("./transport/eventsource"), t("./transport/lib/iframe-wrap")(t("./transport/eventsource")), t("./transport/htmlfile"), t("./transport/lib/iframe-wrap")(t("./transport/htmlfile")), t("./transport/xhr-polling"), t("./transport/xdr-polling"), t("./transport/lib/iframe-wrap")(t("./transport/xhr-polling")), t("./transport/jsonp-polling")]
        }, {
            "./transport/eventsource": 20,
            "./transport/htmlfile": 21,
            "./transport/jsonp-polling": 23,
            "./transport/lib/iframe-wrap": 26,
            "./transport/websocket": 38,
            "./transport/xdr-polling": 39,
            "./transport/xdr-streaming": 40,
            "./transport/xhr-polling": 41,
            "./transport/xhr-streaming": 42
        }],
        17: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t, e, n, r) {
                    var o = this;
                    i.call(this), setTimeout(function() {
                        o._start(t, e, n, r)
                    }, 0)
                }
                var i = t("events").EventEmitter,
                    o = t("inherits"),
                    s = t("../../utils/event"),
                    a = t("../../utils/url"),
                    l = n.XMLHttpRequest;
                o(r, i), r.prototype._start = function(t, e, n, i) {
                    var o = this;
                    try {
                        this.xhr = new l
                    } catch (t) {}
                    if (!this.xhr) return this.emit("finish", 0, "no xhr support"), void this._cleanup();
                    e = a.addQuery(e, "t=" + +new Date), this.unloadRef = s.unloadAdd(function() {
                        o._cleanup(!0)
                    });
                    try {
                        this.xhr.open(t, e, !0), this.timeout && "timeout" in this.xhr && (this.xhr.timeout = this.timeout, this.xhr.ontimeout = function() {
                            o.emit("finish", 0, ""), o._cleanup(!1)
                        })
                    } catch (t) {
                        return this.emit("finish", 0, ""), void this._cleanup(!1)
                    }
                    if (i && i.noCredentials || !r.supportsCORS || (this.xhr.withCredentials = "true"), i && i.headers)
                        for (var u in i.headers) this.xhr.setRequestHeader(u, i.headers[u]);
                    this.xhr.onreadystatechange = function() {
                        if (o.xhr) {
                            var t, e, n = o.xhr;
                            switch (n.readyState, n.readyState) {
                                case 3:
                                    try {
                                        e = n.status, t = n.responseText
                                    } catch (t) {}
                                    1223 === e && (e = 204), 200 === e && t && t.length > 0 && o.emit("chunk", e, t);
                                    break;
                                case 4:
                                    e = n.status, 1223 === e && (e = 204), 12005 !== e && 12029 !== e || (e = 0), n.responseText, o.emit("finish", e, n.responseText), o._cleanup(!1)
                            }
                        }
                    };
                    try {
                        o.xhr.send(n)
                    } catch (t) {
                        o.emit("finish", 0, ""), o._cleanup(!1)
                    }
                }, r.prototype._cleanup = function(t) {
                    if (this.xhr) {
                        if (this.removeAllListeners(), s.unloadDel(this.unloadRef), this.xhr.onreadystatechange = function() {}, this.xhr.ontimeout && (this.xhr.ontimeout = null), t) try {
                            this.xhr.abort()
                        } catch (t) {}
                        this.unloadRef = this.xhr = null
                    }
                }, r.prototype.close = function() {
                    this._cleanup(!0)
                }, r.enabled = !!l;
                var u = ["Active"].concat("Object").join("X");
                !r.enabled && u in n && (l = function() {
                    try {
                        return new n[u]("Microsoft.XMLHTTP")
                    } catch (t) {
                        return null
                    }
                }, r.enabled = !!new l);
                var c = !1;
                try {
                    c = "withCredentials" in new l
                } catch (t) {}
                r.supportsCORS = c, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/event": 46,
            "../../utils/url": 52,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        18: [function(t, e, n) {
            (function(t) {
                e.exports = t.EventSource
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        19: [function(t, e, n) {
            (function(t) {
                "use strict";
                var n = t.WebSocket || t.MozWebSocket;
                e.exports = n ? function(t) {
                    return new n(t)
                } : void 0
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        20: [function(t, e, n) {
            "use strict";

            function r(t) {
                if (!r.enabled()) throw new Error("Transport created when disabled");
                o.call(this, t, "/eventsource", s, a)
            }
            var i = t("inherits"),
                o = t("./lib/ajax-based"),
                s = t("./receiver/eventsource"),
                a = t("./sender/xhr-cors"),
                l = t("eventsource");
            i(r, o), r.enabled = function() {
                return !!l
            }, r.transportName = "eventsource", r.roundTrips = 2, e.exports = r
        }, {
            "./lib/ajax-based": 24,
            "./receiver/eventsource": 29,
            "./sender/xhr-cors": 35,
            "eventsource": 18,
            "inherits": 54
        }],
        21: [function(t, e, n) {
            "use strict";

            function r(t) {
                if (!o.enabled) throw new Error("Transport created when disabled");
                a.call(this, t, "/htmlfile", o, s)
            }
            var i = t("inherits"),
                o = t("./receiver/htmlfile"),
                s = t("./sender/xhr-local"),
                a = t("./lib/ajax-based");
            i(r, a), r.enabled = function(t) {
                return o.enabled && t.sameOrigin
            }, r.transportName = "htmlfile", r.roundTrips = 2, e.exports = r
        }, {
            "./lib/ajax-based": 24,
            "./receiver/htmlfile": 30,
            "./sender/xhr-local": 37,
            "inherits": 54
        }],
        22: [function(t, e, n) {
            "use strict";

            function r(t, e, n) {
                if (!r.enabled()) throw new Error("Transport created when disabled");
                s.call(this);
                var i = this;
                this.origin = l.getOrigin(n), this.baseUrl = n, this.transUrl = e, this.transport = t, this.windowId = f.string(8);
                var o = l.addPath(n, "/iframe.html") + "#" + this.windowId;
                this.iframeObj = u.createIframe(o, function(t) {
                    i.emit("close", 1006, "Unable to load an iframe (" + t + ")"), i.close()
                }), this.onmessageCallback = this._message.bind(this), c.attachEvent("message", this.onmessageCallback)
            }
            var i = t("inherits"),
                o = t("json3"),
                s = t("events").EventEmitter,
                a = t("../version"),
                l = t("../utils/url"),
                u = t("../utils/iframe"),
                c = t("../utils/event"),
                f = t("../utils/random");
            i(r, s), r.prototype.close = function() {
                if (this.removeAllListeners(), this.iframeObj) {
                    c.detachEvent("message", this.onmessageCallback);
                    try {
                        this.postMessage("c")
                    } catch (t) {}
                    this.iframeObj.cleanup(), this.iframeObj = null, this.onmessageCallback = this.iframeObj = null
                }
            }, r.prototype._message = function(t) {
                if (t.data, !l.isOriginEqual(t.origin, this.origin)) return t.origin, void this.origin;
                var e;
                try {
                    e = o.parse(t.data)
                } catch (e) {
                    return void t.data
                }
                if (e.windowId !== this.windowId) return e.windowId, void this.windowId;
                switch (e.type) {
                    case "s":
                        this.iframeObj.loaded(), this.postMessage("s", o.stringify([a, this.transport, this.transUrl, this.baseUrl]));
                        break;
                    case "t":
                        this.emit("message", e.data);
                        break;
                    case "c":
                        var n;
                        try {
                            n = o.parse(e.data)
                        } catch (t) {
                            return void e.data
                        }
                        this.emit("close", n[0], n[1]), this.close()
                }
            }, r.prototype.postMessage = function(t, e) {
                this.iframeObj.post(o.stringify({
                    windowId: this.windowId,
                    type: t,
                    data: e || ""
                }), this.origin)
            }, r.prototype.send = function(t) {
                this.postMessage("m", t)
            }, r.enabled = function() {
                return u.iframeEnabled
            }, r.transportName = "iframe", r.roundTrips = 2, e.exports = r
        }, {
            "../utils/event": 46,
            "../utils/iframe": 47,
            "../utils/random": 50,
            "../utils/url": 52,
            "../version": 53,
            "debug": void 0,
            "events": 3,
            "inherits": 54,
            "json3": 55
        }],
        23: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t) {
                    if (!r.enabled()) throw new Error("Transport created when disabled");
                    o.call(this, t, "/jsonp", a, s)
                }
                var i = t("inherits"),
                    o = t("./lib/sender-receiver"),
                    s = t("./receiver/jsonp"),
                    a = t("./sender/jsonp");
                i(r, o), r.enabled = function() {
                    return !!n.document
                }, r.transportName = "jsonp-polling", r.roundTrips = 1, r.needBody = !0, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./lib/sender-receiver": 28,
            "./receiver/jsonp": 31,
            "./sender/jsonp": 33,
            "inherits": 54
        }],
        24: [function(t, e, n) {
            "use strict";

            function r(t) {
                return function(e, n, r) {
                    var i = {};
                    "string" == typeof n && (i.headers = {
                        "Content-type": "text/plain"
                    });
                    var o = s.addPath(e, "/xhr_send"),
                        a = new t("POST", o, n, i);
                    return a.once("finish", function(t) {
                        if (a = null, 200 !== t && 204 !== t) return r(new Error("http status " + t));
                        r()
                    }),
                        function() {
                            a.close(), a = null;
                            var t = new Error("Aborted");
                            t.code = 1e3, r(t)
                        }
                }
            }

            function i(t, e, n, i) {
                a.call(this, t, e, r(i), n, i)
            }
            var o = t("inherits"),
                s = t("../../utils/url"),
                a = t("./sender-receiver");
            o(i, a), e.exports = i
        }, {
            "../../utils/url": 52,
            "./sender-receiver": 28,
            "debug": void 0,
            "inherits": 54
        }],
        25: [function(t, e, n) {
            "use strict";

            function r(t, e) {
                o.call(this), this.sendBuffer = [], this.sender = e, this.url = t
            }
            var i = t("inherits"),
                o = t("events").EventEmitter;
            i(r, o), r.prototype.send = function(t) {
                this.sendBuffer.push(t), this.sendStop || this.sendSchedule()
            }, r.prototype.sendScheduleWait = function() {
                var t, e = this;
                this.sendStop = function() {
                    e.sendStop = null, clearTimeout(t)
                }, t = setTimeout(function() {
                    e.sendStop = null, e.sendSchedule()
                }, 25)
            }, r.prototype.sendSchedule = function() {
                this.sendBuffer.length;
                var t = this;
                if (this.sendBuffer.length > 0) {
                    var e = "[" + this.sendBuffer.join(",") + "]";
                    this.sendStop = this.sender(this.url, e, function(e) {
                        t.sendStop = null, e ? (t.emit("close", e.code || 1006, "Sending error: " + e), t.close()) : t.sendScheduleWait()
                    }), this.sendBuffer = []
                }
            }, r.prototype._cleanup = function() {
                this.removeAllListeners()
            }, r.prototype.close = function() {
                this._cleanup(), this.sendStop && (this.sendStop(), this.sendStop = null)
            }, e.exports = r
        }, {
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        26: [function(t, e, n) {
            (function(n) {
                "use strict";
                var r = t("inherits"),
                    i = t("../iframe"),
                    o = t("../../utils/object");
                e.exports = function(t) {
                    function e(e, n) {
                        i.call(this, t.transportName, e, n)
                    }
                    return r(e, i), e.enabled = function(e, r) {
                        if (!n.document) return !1;
                        var s = o.extend({}, r);
                        return s.sameOrigin = !0, t.enabled(s) && i.enabled()
                    }, e.transportName = "iframe-" + t.transportName, e.needBody = !0, e.roundTrips = i.roundTrips + t.roundTrips - 1, e.facadeTransport = t, e
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/object": 49,
            "../iframe": 22,
            "inherits": 54
        }],
        27: [function(t, e, n) {
            "use strict";

            function r(t, e, n) {
                o.call(this), this.Receiver = t, this.receiveUrl = e, this.AjaxObject = n, this._scheduleReceiver()
            }
            var i = t("inherits"),
                o = t("events").EventEmitter;
            i(r, o), r.prototype._scheduleReceiver = function() {
                var t = this,
                    e = this.poll = new this.Receiver(this.receiveUrl, this.AjaxObject);
                e.on("message", function(e) {
                    t.emit("message", e)
                }), e.once("close", function(n, r) {
                    t.pollIsClosing, t.poll = e = null, t.pollIsClosing || ("network" === r ? t._scheduleReceiver() : (t.emit("close", n || 1006, r), t.removeAllListeners()))
                })
            }, r.prototype.abort = function() {
                this.removeAllListeners(), this.pollIsClosing = !0, this.poll && this.poll.abort()
            }, e.exports = r
        }, {
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        28: [function(t, e, n) {
            "use strict";

            function r(t, e, n, r, i) {
                var l = o.addPath(t, e),
                    u = this;
                s.call(this, t, n), this.poll = new a(r, l, i), this.poll.on("message", function(t) {
                    u.emit("message", t)
                }), this.poll.once("close", function(t, e) {
                    u.poll = null, u.emit("close", t, e), u.close()
                })
            }
            var i = t("inherits"),
                o = t("../../utils/url"),
                s = t("./buffered-sender"),
                a = t("./polling");
            i(r, s), r.prototype.close = function() {
                s.prototype.close.call(this), this.removeAllListeners(), this.poll && (this.poll.abort(), this.poll = null)
            }, e.exports = r
        }, {
            "../../utils/url": 52,
            "./buffered-sender": 25,
            "./polling": 27,
            "debug": void 0,
            "inherits": 54
        }],
        29: [function(t, e, n) {
            "use strict";

            function r(t) {
                o.call(this);
                var e = this,
                    n = this.es = new s(t);
                n.onmessage = function(t) {
                    t.data, e.emit("message", decodeURI(t.data))
                }, n.onerror = function(t) {
                    n.readyState;
                    var r = 2 !== n.readyState ? "network" : "permanent";
                    e._cleanup(), e._close(r)
                }
            }
            var i = t("inherits"),
                o = t("events").EventEmitter,
                s = t("eventsource");
            i(r, o), r.prototype.abort = function() {
                this._cleanup(), this._close("user")
            }, r.prototype._cleanup = function() {
                var t = this.es;
                t && (t.onmessage = t.onerror = null, t.close(), this.es = null)
            }, r.prototype._close = function(t) {
                var e = this;
                setTimeout(function() {
                    e.emit("close", null, t), e.removeAllListeners()
                }, 200)
            }, e.exports = r
        }, {
            "debug": void 0,
            "events": 3,
            "eventsource": 18,
            "inherits": 54
        }],
        30: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t) {
                    a.call(this);
                    var e = this;
                    o.polluteGlobalNamespace(), this.id = "a" + l.string(6), t = s.addQuery(t, "c=" + decodeURIComponent(o.WPrefix + "." + this.id)), r.htmlfileEnabled;
                    var i = r.htmlfileEnabled ? o.createHtmlfile : o.createIframe;
                    n[o.WPrefix][this.id] = {
                        start: function() {
                            e.iframeObj.loaded()
                        },
                        message: function(t) {
                            e.emit("message", t)
                        },
                        stop: function() {
                            e._cleanup(), e._close("network")
                        }
                    }, this.iframeObj = i(t, function() {
                        e._cleanup(), e._close("permanent")
                    })
                }
                var i = t("inherits"),
                    o = t("../../utils/iframe"),
                    s = t("../../utils/url"),
                    a = t("events").EventEmitter,
                    l = t("../../utils/random");
                i(r, a), r.prototype.abort = function() {
                    this._cleanup(), this._close("user")
                }, r.prototype._cleanup = function() {
                    this.iframeObj && (this.iframeObj.cleanup(), this.iframeObj = null), delete n[o.WPrefix][this.id]
                }, r.prototype._close = function(t) {
                    this.emit("close", null, t), this.removeAllListeners()
                }, r.htmlfileEnabled = !1;
                var u = ["Active"].concat("Object").join("X");
                if (u in n) try {
                    r.htmlfileEnabled = !!new n[u]("htmlfile")
                } catch (t) {}
                r.enabled = r.htmlfileEnabled || o.iframeEnabled, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/iframe": 47,
            "../../utils/random": 50,
            "../../utils/url": 52,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        31: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t) {
                    var e = this;
                    u.call(this), i.polluteGlobalNamespace(), this.id = "a" + o.string(6);
                    var s = a.addQuery(t, "c=" + encodeURIComponent(i.WPrefix + "." + this.id));
                    n[i.WPrefix][this.id] = this._callback.bind(this), this._createScript(s), this.timeoutId = setTimeout(function() {
                        e._abort(new Error("JSONP script loaded abnormally (timeout)"))
                    }, r.timeout)
                }
                var i = t("../../utils/iframe"),
                    o = t("../../utils/random"),
                    s = t("../../utils/browser"),
                    a = t("../../utils/url"),
                    l = t("inherits"),
                    u = t("events").EventEmitter;
                l(r, u), r.prototype.abort = function() {
                    if (n[i.WPrefix][this.id]) {
                        var t = new Error("JSONP user aborted read");
                        t.code = 1e3, this._abort(t)
                    }
                }, r.timeout = 35e3, r.scriptErrorTimeout = 1e3, r.prototype._callback = function(t) {
                    this._cleanup(), this.aborting || (t && this.emit("message", t), this.emit("close", null, "network"), this.removeAllListeners())
                }, r.prototype._abort = function(t) {
                    this._cleanup(), this.aborting = !0, this.emit("close", t.code, t.message), this.removeAllListeners()
                }, r.prototype._cleanup = function() {
                    if (clearTimeout(this.timeoutId), this.script2 && (this.script2.parentNode.removeChild(this.script2), this.script2 = null), this.script) {
                        var t = this.script;
                        t.parentNode.removeChild(t), t.onreadystatechange = t.onerror = t.onload = t.onclick = null, this.script = null
                    }
                    delete n[i.WPrefix][this.id]
                }, r.prototype._scriptError = function() {
                    var t = this;
                    this.errorTimer || (this.errorTimer = setTimeout(function() {
                        t.loadedOkay || t._abort(new Error("JSONP script loaded abnormally (onerror)"))
                    }, r.scriptErrorTimeout))
                }, r.prototype._createScript = function(t) {
                    var e, r = this,
                        i = this.script = n.document.createElement("script");
                    if (i.id = "a" + o.string(8), i.src = t, i.type = "text/javascript", i.charset = "UTF-8", i.onerror = this._scriptError.bind(this), i.onload = function() {
                        r._abort(new Error("JSONP script loaded abnormally (onload)"))
                    }, i.onreadystatechange = function() {
                        if (i.readyState, /loaded|closed/.test(i.readyState)) {
                            if (i && i.htmlFor && i.onclick) {
                                r.loadedOkay = !0;
                                try {
                                    i.onclick()
                                } catch (t) {}
                            }
                            i && r._abort(new Error("JSONP script loaded abnormally (onreadystatechange)"))
                        }
                    }, void 0 === i.async && n.document.attachEvent)
                        if (s.isOpera()) e = this.script2 = n.document.createElement("script"), e.text = "try{var a = document.getElementById('" + i.id + "'); if(a)a.onerror();}catch(x){};", i.async = e.async = !1;
                        else {
                            try {
                                i.htmlFor = i.id, i.event = "onclick"
                            } catch (t) {}
                            i.async = !0
                        } void 0 !== i.async && (i.async = !0);
                    var a = n.document.getElementsByTagName("head")[0];
                    a.insertBefore(i, a.firstChild), e && a.insertBefore(e, a.firstChild)
                }, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/browser": 44,
            "../../utils/iframe": 47,
            "../../utils/random": 50,
            "../../utils/url": 52,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        32: [function(t, e, n) {
            "use strict";

            function r(t, e) {
                o.call(this);
                var n = this;
                this.bufferPosition = 0, this.xo = new e("POST", t, null), this.xo.on("chunk", this._chunkHandler.bind(this)), this.xo.once("finish", function(t, e) {
                    n._chunkHandler(t, e), n.xo = null;
                    var r = 200 === t ? "network" : "permanent";
                    n.emit("close", null, r), n._cleanup()
                })
            }
            var i = t("inherits"),
                o = t("events").EventEmitter;
            i(r, o), r.prototype._chunkHandler = function(t, e) {
                if (200 === t && e)
                    for (var n = -1;; this.bufferPosition += n + 1) {
                        var r = e.slice(this.bufferPosition);
                        if (-1 === (n = r.indexOf("\n"))) break;
                        var i = r.slice(0, n);
                        i && this.emit("message", i)
                    }
            }, r.prototype._cleanup = function() {
                this.removeAllListeners()
            }, r.prototype.abort = function() {
                this.xo && (this.xo.close(), this.emit("close", null, "user"), this.xo = null), this._cleanup()
            }, e.exports = r
        }, {
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        33: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t) {
                    try {
                        return n.document.createElement('<iframe name="' + t + '">')
                    } catch (r) {
                        var e = n.document.createElement("iframe");
                        return e.name = t, e
                    }
                }

                function i() {
                    o = n.document.createElement("form"), o.style.display = "none", o.style.position = "absolute", o.method = "POST", o.enctype = "application/x-www-form-urlencoded", o.acceptCharset = "UTF-8", s = n.document.createElement("textarea"), s.name = "d", o.appendChild(s), n.document.body.appendChild(o)
                }
                var o, s, a = t("../../utils/random"),
                    l = t("../../utils/url");
                e.exports = function(t, e, n) {
                    o || i();
                    var u = "a" + a.string(8);
                    o.target = u, o.action = l.addQuery(l.addPath(t, "/jsonp_send"), "i=" + u);
                    var c = r(u);
                    c.id = u, c.style.display = "none", o.appendChild(c);
                    try {
                        s.value = e
                    } catch (t) {}
                    o.submit();
                    var f = function(t) {
                        c.onerror && (c.onreadystatechange = c.onerror = c.onload = null, setTimeout(function() {
                            c.parentNode.removeChild(c), c = null
                        }, 500), s.value = "", n(t))
                    };
                    return c.onerror = function() {
                        f()
                    }, c.onload = function() {
                        f()
                    }, c.onreadystatechange = function(t) {
                        c.readyState, "complete" === c.readyState && f()
                    },
                        function() {
                            f(new Error("Aborted"))
                        }
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/random": 50,
            "../../utils/url": 52,
            "debug": void 0
        }],
        34: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t, e, n) {
                    var r = this;
                    i.call(this), setTimeout(function() {
                        r._start(t, e, n)
                    }, 0)
                }
                var i = t("events").EventEmitter,
                    o = t("inherits"),
                    s = t("../../utils/event"),
                    a = t("../../utils/browser"),
                    l = t("../../utils/url");
                o(r, i), r.prototype._start = function(t, e, r) {
                    var i = this,
                        o = new n.XDomainRequest;
                    e = l.addQuery(e, "t=" + +new Date), o.onerror = function() {
                        i._error()
                    }, o.ontimeout = function() {
                        i._error()
                    }, o.onprogress = function() {
                        o.responseText, i.emit("chunk", 200, o.responseText)
                    }, o.onload = function() {
                        i.emit("finish", 200, o.responseText), i._cleanup(!1)
                    }, this.xdr = o, this.unloadRef = s.unloadAdd(function() {
                        i._cleanup(!0)
                    });
                    try {
                        this.xdr.open(t, e), this.timeout && (this.xdr.timeout = this.timeout), this.xdr.send(r)
                    } catch (t) {
                        this._error()
                    }
                }, r.prototype._error = function() {
                    this.emit("finish", 0, ""), this._cleanup(!1)
                }, r.prototype._cleanup = function(t) {
                    if (this.xdr) {
                        if (this.removeAllListeners(), s.unloadDel(this.unloadRef), this.xdr.ontimeout = this.xdr.onerror = this.xdr.onprogress = this.xdr.onload = null, t) try {
                            this.xdr.abort()
                        } catch (t) {}
                        this.unloadRef = this.xdr = null
                    }
                }, r.prototype.close = function() {
                    this._cleanup(!0)
                }, r.enabled = !(!n.XDomainRequest || !a.hasDomain()), e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../../utils/browser": 44,
            "../../utils/event": 46,
            "../../utils/url": 52,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        35: [function(t, e, n) {
            "use strict";

            function r(t, e, n, r) {
                o.call(this, t, e, n, r)
            }
            var i = t("inherits"),
                o = t("../driver/xhr");
            i(r, o), r.enabled = o.enabled && o.supportsCORS, e.exports = r
        }, {
            "../driver/xhr": 17,
            "inherits": 54
        }],
        36: [function(t, e, n) {
            "use strict";

            function r() {
                var t = this;
                i.call(this), this.to = setTimeout(function() {
                    t.emit("finish", 200, "{}")
                }, r.timeout)
            }
            var i = t("events").EventEmitter;
            t("inherits")(r, i), r.prototype.close = function() {
                clearTimeout(this.to)
            }, r.timeout = 2e3, e.exports = r
        }, {
            "events": 3,
            "inherits": 54
        }],
        37: [function(t, e, n) {
            "use strict";

            function r(t, e, n) {
                o.call(this, t, e, n, {
                    noCredentials: !0
                })
            }
            var i = t("inherits"),
                o = t("../driver/xhr");
            i(r, o), r.enabled = o.enabled, e.exports = r
        }, {
            "../driver/xhr": 17,
            "inherits": 54
        }],
        38: [function(t, e, n) {
            "use strict";

            function r(t, e, n) {
                if (!r.enabled()) throw new Error("Transport created when disabled");
                a.call(this);
                var s = this,
                    u = o.addPath(t, "/websocket");
                u = "https" === u.slice(0, 5) ? "wss" + u.slice(5) : "ws" + u.slice(4), this.url = u, this.ws = new l(this.url, [], n), this.ws.onmessage = function(t) {
                    t.data, s.emit("message", t.data)
                }, this.unloadRef = i.unloadAdd(function() {
                    s.ws.close()
                }), this.ws.onclose = function(t) {
                    t.code, t.reason, s.emit("close", t.code, t.reason), s._cleanup()
                }, this.ws.onerror = function(t) {
                    s.emit("close", 1006, "WebSocket connection broken"), s._cleanup()
                }
            }
            var i = t("../utils/event"),
                o = t("../utils/url"),
                s = t("inherits"),
                a = t("events").EventEmitter,
                l = t("./driver/websocket");
            s(r, a), r.prototype.send = function(t) {
                var e = "[" + t + "]";
                this.ws.send(e)
            }, r.prototype.close = function() {
                var t = this.ws;
                this._cleanup(), t && t.close()
            }, r.prototype._cleanup = function() {
                var t = this.ws;
                t && (t.onmessage = t.onclose = t.onerror = null), i.unloadDel(this.unloadRef), this.unloadRef = this.ws = null, this.removeAllListeners()
            }, r.enabled = function() {
                return !!l
            }, r.transportName = "websocket", r.roundTrips = 2, e.exports = r
        }, {
            "../utils/event": 46,
            "../utils/url": 52,
            "./driver/websocket": 19,
            "debug": void 0,
            "events": 3,
            "inherits": 54
        }],
        39: [function(t, e, n) {
            "use strict";

            function r(t) {
                if (!l.enabled) throw new Error("Transport created when disabled");
                o.call(this, t, "/xhr", a, l)
            }
            var i = t("inherits"),
                o = t("./lib/ajax-based"),
                s = t("./xdr-streaming"),
                a = t("./receiver/xhr"),
                l = t("./sender/xdr");
            i(r, o), r.enabled = s.enabled, r.transportName = "xdr-polling", r.roundTrips = 2, e.exports = r
        }, {
            "./lib/ajax-based": 24,
            "./receiver/xhr": 32,
            "./sender/xdr": 34,
            "./xdr-streaming": 40,
            "inherits": 54
        }],
        40: [function(t, e, n) {
            "use strict";

            function r(t) {
                if (!a.enabled) throw new Error("Transport created when disabled");
                o.call(this, t, "/xhr_streaming", s, a)
            }
            var i = t("inherits"),
                o = t("./lib/ajax-based"),
                s = t("./receiver/xhr"),
                a = t("./sender/xdr");
            i(r, o), r.enabled = function(t) {
                return !t.cookie_needed && !t.nullOrigin && (a.enabled && t.sameScheme)
            }, r.transportName = "xdr-streaming", r.roundTrips = 2, e.exports = r
        }, {
            "./lib/ajax-based": 24,
            "./receiver/xhr": 32,
            "./sender/xdr": 34,
            "inherits": 54
        }],
        41: [function(t, e, n) {
            "use strict";

            function r(t) {
                if (!l.enabled && !a.enabled) throw new Error("Transport created when disabled");
                o.call(this, t, "/xhr", s, a)
            }
            var i = t("inherits"),
                o = t("./lib/ajax-based"),
                s = t("./receiver/xhr"),
                a = t("./sender/xhr-cors"),
                l = t("./sender/xhr-local");
            i(r, o), r.enabled = function(t) {
                return !t.nullOrigin && (!(!l.enabled || !t.sameOrigin) || a.enabled)
            }, r.transportName = "xhr-polling", r.roundTrips = 2, e.exports = r
        }, {
            "./lib/ajax-based": 24,
            "./receiver/xhr": 32,
            "./sender/xhr-cors": 35,
            "./sender/xhr-local": 37,
            "inherits": 54
        }],
        42: [function(t, e, n) {
            (function(n) {
                "use strict";

                function r(t) {
                    if (!l.enabled && !a.enabled) throw new Error("Transport created when disabled");
                    o.call(this, t, "/xhr_streaming", s, a)
                }
                var i = t("inherits"),
                    o = t("./lib/ajax-based"),
                    s = t("./receiver/xhr"),
                    a = t("./sender/xhr-cors"),
                    l = t("./sender/xhr-local"),
                    u = t("../utils/browser");
                i(r, o), r.enabled = function(t) {
                    return !t.nullOrigin && (!u.isOpera() && a.enabled)
                }, r.transportName = "xhr-streaming", r.roundTrips = 2, r.needBody = !!n.document, e.exports = r
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "../utils/browser": 44,
            "./lib/ajax-based": 24,
            "./receiver/xhr": 32,
            "./sender/xhr-cors": 35,
            "./sender/xhr-local": 37,
            "inherits": 54
        }],
        43: [function(t, e, n) {
            (function(t) {
                "use strict";
                t.crypto && t.crypto.getRandomValues ? e.exports.randomBytes = function(e) {
                    var n = new Uint8Array(e);
                    return t.crypto.getRandomValues(n), n
                } : e.exports.randomBytes = function(t) {
                    for (var e = new Array(t), n = 0; n < t; n++) e[n] = Math.floor(256 * Math.random());
                    return e
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        44: [function(t, e, n) {
            (function(t) {
                "use strict";
                e.exports = {
                    isOpera: function() {
                        return t.navigator && /opera/i.test(t.navigator.userAgent)
                    },
                    isKonqueror: function() {
                        return t.navigator && /konqueror/i.test(t.navigator.userAgent)
                    },
                    hasDomain: function() {
                        if (!t.document) return !0;
                        try {
                            return !!t.document.domain
                        } catch (t) {
                            return !1
                        }
                    }
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        45: [function(t, e, n) {
            "use strict";
            var r, i = t("json3"),
                o = /[\x00-\x1f\ud800-\udfff\ufffe\uffff\u0300-\u0333\u033d-\u0346\u034a-\u034c\u0350-\u0352\u0357-\u0358\u035c-\u0362\u0374\u037e\u0387\u0591-\u05af\u05c4\u0610-\u0617\u0653-\u0654\u0657-\u065b\u065d-\u065e\u06df-\u06e2\u06eb-\u06ec\u0730\u0732-\u0733\u0735-\u0736\u073a\u073d\u073f-\u0741\u0743\u0745\u0747\u07eb-\u07f1\u0951\u0958-\u095f\u09dc-\u09dd\u09df\u0a33\u0a36\u0a59-\u0a5b\u0a5e\u0b5c-\u0b5d\u0e38-\u0e39\u0f43\u0f4d\u0f52\u0f57\u0f5c\u0f69\u0f72-\u0f76\u0f78\u0f80-\u0f83\u0f93\u0f9d\u0fa2\u0fa7\u0fac\u0fb9\u1939-\u193a\u1a17\u1b6b\u1cda-\u1cdb\u1dc0-\u1dcf\u1dfc\u1dfe\u1f71\u1f73\u1f75\u1f77\u1f79\u1f7b\u1f7d\u1fbb\u1fbe\u1fc9\u1fcb\u1fd3\u1fdb\u1fe3\u1feb\u1fee-\u1fef\u1ff9\u1ffb\u1ffd\u2000-\u2001\u20d0-\u20d1\u20d4-\u20d7\u20e7-\u20e9\u2126\u212a-\u212b\u2329-\u232a\u2adc\u302b-\u302c\uaab2-\uaab3\uf900-\ufa0d\ufa10\ufa12\ufa15-\ufa1e\ufa20\ufa22\ufa25-\ufa26\ufa2a-\ufa2d\ufa30-\ufa6d\ufa70-\ufad9\ufb1d\ufb1f\ufb2a-\ufb36\ufb38-\ufb3c\ufb3e\ufb40-\ufb41\ufb43-\ufb44\ufb46-\ufb4e\ufff0-\uffff]/g,
                s = function(t) {
                    var e, n = {},
                        r = [];
                    for (e = 0; e < 65536; e++) r.push(String.fromCharCode(e));
                    return t.lastIndex = 0, r.join("").replace(t, function(t) {
                        return n[t] = "\\u" + ("0000" + t.charCodeAt(0).toString(16)).slice(-4), ""
                    }), t.lastIndex = 0, n
                };
            e.exports = {
                quote: function(t) {
                    var e = i.stringify(t);
                    return o.lastIndex = 0, o.test(e) ? (r || (r = s(o)), e.replace(o, function(t) {
                        return r[t]
                    })) : e
                }
            }
        }, {
            "json3": 55
        }],
        46: [function(t, e, n) {
            (function(n) {
                "use strict";
                var r = t("./random"),
                    i = {},
                    o = !1,
                    s = n.chrome && n.chrome.app && n.chrome.app.runtime;
                e.exports = {
                    attachEvent: function(t, e) {
                        void 0 !== n.addEventListener ? n.addEventListener(t, e, !1) : n.document && n.attachEvent && (n.document.attachEvent("on" + t, e), n.attachEvent("on" + t, e))
                    },
                    detachEvent: function(t, e) {
                        void 0 !== n.addEventListener ? n.removeEventListener(t, e, !1) : n.document && n.detachEvent && (n.document.detachEvent("on" + t, e), n.detachEvent("on" + t, e))
                    },
                    unloadAdd: function(t) {
                        if (s) return null;
                        var e = r.string(8);
                        return i[e] = t, o && setTimeout(this.triggerUnloadCallbacks, 0), e
                    },
                    unloadDel: function(t) {
                        t in i && delete i[t]
                    },
                    triggerUnloadCallbacks: function() {
                        for (var t in i) i[t](), delete i[t]
                    }
                };
                var a = function() {
                    o || (o = !0, e.exports.triggerUnloadCallbacks())
                };
                s || e.exports.attachEvent("unload", a)
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./random": 50
        }],
        47: [function(t, e, n) {
            (function(n) {
                "use strict";
                var r = t("./event"),
                    i = t("json3"),
                    o = t("./browser");
                e.exports = {
                    WPrefix: "_jp",
                    currentWindowId: null,
                    polluteGlobalNamespace: function() {
                        e.exports.WPrefix in n || (n[e.exports.WPrefix] = {})
                    },
                    postMessage: function(t, r) {
                        n.parent !== n && n.parent.postMessage(i.stringify({
                            windowId: e.exports.currentWindowId,
                            type: t,
                            data: r || ""
                        }), "*")
                    },
                    createIframe: function(t, e) {
                        var i, o, s = n.document.createElement("iframe"),
                            a = function() {
                                clearTimeout(i);
                                try {
                                    s.onload = null
                                } catch (t) {}
                                s.onerror = null
                            },
                            l = function() {
                                s && (a(), setTimeout(function() {
                                    s && s.parentNode.removeChild(s), s = null
                                }, 0), r.unloadDel(o))
                            },
                            u = function(t) {
                                s && (l(), e(t))
                            },
                            c = function(t, e) {
                                try {
                                    setTimeout(function() {
                                        s && s.contentWindow && s.contentWindow.postMessage(t, e)
                                    }, 0)
                                } catch (t) {}
                            };
                        return s.src = t, s.style.display = "none", s.style.position = "absolute", s.onerror = function() {
                            u("onerror")
                        }, s.onload = function() {
                            clearTimeout(i), i = setTimeout(function() {
                                u("onload timeout")
                            }, 2e3)
                        }, n.document.body.appendChild(s), i = setTimeout(function() {
                            u("timeout")
                        }, 15e3), o = r.unloadAdd(l), {
                            post: c,
                            cleanup: l,
                            loaded: a
                        }
                    },
                    createHtmlfile: function(t, i) {
                        var o, s, a, l = ["Active"].concat("Object").join("X"),
                            u = new n[l]("htmlfile"),
                            c = function() {
                                clearTimeout(o), a.onerror = null
                            },
                            f = function() {
                                u && (c(), r.unloadDel(s), a.parentNode.removeChild(a), a = u = null, CollectGarbage())
                            },
                            h = function(t) {
                                u && (f(), i(t))
                            },
                            d = function(t, e) {
                                try {
                                    setTimeout(function() {
                                        a && a.contentWindow && a.contentWindow.postMessage(t, e)
                                    }, 0)
                                } catch (t) {}
                            };
                        u.open(), u.write('<html><script>document.domain="' + n.document.domain + '";<\/script></html>'), u.close(), u.parentWindow[e.exports.WPrefix] = n[e.exports.WPrefix];
                        var p = u.createElement("div");
                        return u.body.appendChild(p), a = u.createElement("iframe"), p.appendChild(a), a.src = t, a.onerror = function() {
                            h("onerror")
                        }, o = setTimeout(function() {
                            h("timeout")
                        }, 15e3), s = r.unloadAdd(f), {
                            post: d,
                            cleanup: f,
                            loaded: c
                        }
                    }
                }, e.exports.iframeEnabled = !1, n.document && (e.exports.iframeEnabled = ("function" == typeof n.postMessage || "object" == typeof n.postMessage) && !o.isKonqueror())
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./browser": 44,
            "./event": 46,
            "debug": void 0,
            "json3": 55
        }],
        48: [function(t, e, n) {
            (function(t) {
                "use strict";
                var n = {};
                ["log", "debug", "warn"].forEach(function(e) {
                    var r;
                    try {
                        r = t.console && t.console[e] && t.console[e].apply
                    } catch (t) {}
                    n[e] = r ? function() {
                        return t.console[e].apply(t.console, arguments)
                    } : "log" === e ? function() {} : n.log
                }), e.exports = n
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        49: [function(t, e, n) {
            "use strict";
            e.exports = {
                isObject: function(t) {
                    var e = typeof t;
                    return "function" === e || "object" === e && !!t
                },
                extend: function(t) {
                    if (!this.isObject(t)) return t;
                    for (var e, n, r = 1, i = arguments.length; r < i; r++) {
                        e = arguments[r];
                        for (n in e) Object.prototype.hasOwnProperty.call(e, n) && (t[n] = e[n])
                    }
                    return t
                }
            }
        }, {}],
        50: [function(t, e, n) {
            "use strict";
            var r = t("crypto"),
                i = "abcdefghijklmnopqrstuvwxyz012345";
            e.exports = {
                string: function(t) {
                    for (var e = i.length, n = r.randomBytes(t), o = [], s = 0; s < t; s++) o.push(i.substr(n[s] % e, 1));
                    return o.join("")
                },
                number: function(t) {
                    return Math.floor(Math.random() * t)
                },
                numberString: function(t) {
                    var e = ("" + (t - 1)).length;
                    return (new Array(e + 1).join("0") + this.number(t)).slice(-e)
                }
            }
        }, {
            "crypto": 43
        }],
        51: [function(t, e, n) {
            "use strict";
            e.exports = function(t) {
                return {
                    filterToEnabled: function(e, n) {
                        var r = {
                            main: [],
                            facade: []
                        };
                        return e ? "string" == typeof e && (e = [e]) : e = [], t.forEach(function(t) {
                            if (t && ("websocket" !== t.transportName || !1 !== n.websocket)) return e.length && -1 === e.indexOf(t.transportName) ? void t.transportName : void(t.enabled(n) ? (t.transportName, r.main.push(t), t.facadeTransport && r.facade.push(t.facadeTransport)) : t.transportName)
                        }), r
                    }
                }
            }
        }, {
            "debug": void 0
        }],
        52: [function(t, e, n) {
            "use strict";
            var r = t("url-parse");
            e.exports = {
                getOrigin: function(t) {
                    if (!t) return null;
                    var e = new r(t);
                    if ("file:" === e.protocol) return null;
                    var n = e.port;
                    return n || (n = "https:" === e.protocol ? "443" : "80"), e.protocol + "//" + e.hostname + ":" + n
                },
                isOriginEqual: function(t, e) {
                    var n = this.getOrigin(t) === this.getOrigin(e);
                    return n
                },
                isSchemeEqual: function(t, e) {
                    return t.split(":")[0] === e.split(":")[0]
                },
                addPath: function(t, e) {
                    var n = t.split("?");
                    return n[0] + e + (n[1] ? "?" + n[1] : "")
                },
                addQuery: function(t, e) {
                    return t + (-1 === t.indexOf("?") ? "?" + e : "&" + e)
                }
            }
        }, {
            "debug": void 0,
            "url-parse": 58
        }],
        53: [function(t, e, n) {
            e.exports = "1.1.4"
        }, {}],
        54: [function(t, e, n) {
            "function" == typeof Object.create ? e.exports = function(t, e) {
                t.super_ = e, t.prototype = Object.create(e.prototype, {
                    constructor: {
                        value: t,
                        enumerable: !1,
                        writable: !0,
                        configurable: !0
                    }
                })
            } : e.exports = function(t, e) {
                t.super_ = e;
                var n = function() {};
                n.prototype = e.prototype, t.prototype = new n, t.prototype.constructor = t
            }
        }, {}],
        55: [function(e, n, r) {
            (function(e) {
                (function() {
                    function i(t, e) {
                        function n(t) {
                            if (n[t] !== m) return n[t];
                            var i;
                            if ("bug-string-char-index" == t) i = "a" != "a" [0];
                            else if ("json" == t) i = n("json-stringify") && n("json-parse");
                            else {
                                var s, a = '{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}';
                                if ("json-stringify" == t) {
                                    var l = e.stringify,
                                        c = "function" == typeof l && g;
                                    if (c) {
                                        (s = function() {
                                            return 1
                                        }).toJSON = s;
                                        try {
                                            c = "0" === l(0) && "0" === l(new r) && '""' == l(new o) && l(y) === m && l(m) === m && l() === m && "1" === l(s) && "[1]" == l([s]) && "[null]" == l([m]) && "null" == l(null) && "[null,null,null]" == l([m, y, null]) && l({
                                                "a": [s, !0, !1, null, "\0\b\n\f\r\t"]
                                            }) == a && "1" === l(null, s) && "[\n 1,\n 2\n]" == l([1, 2], null, 1) && '"-271821-04-20T00:00:00.000Z"' == l(new u(-864e13)) && '"+275760-09-13T00:00:00.000Z"' == l(new u(864e13)) && '"-000001-01-01T00:00:00.000Z"' == l(new u(-621987552e5)) && '"1969-12-31T23:59:59.999Z"' == l(new u(-1))
                                        } catch (t) {
                                            c = !1
                                        }
                                    }
                                    i = c
                                }
                                if ("json-parse" == t) {
                                    var f = e.parse;
                                    if ("function" == typeof f) try {
                                        if (0 === f("0") && !f(!1)) {
                                            s = f(a);
                                            var h = 5 == s.a.length && 1 === s.a[0];
                                            if (h) {
                                                try {
                                                    h = !f('"\t"')
                                                } catch (t) {}
                                                if (h) try {
                                                    h = 1 !== f("01")
                                                } catch (t) {}
                                                if (h) try {
                                                    h = 1 !== f("1.")
                                                } catch (t) {}
                                            }
                                        }
                                    } catch (t) {
                                        h = !1
                                    }
                                    i = h
                                }
                            }
                            return n[t] = !!i
                        }
                        t || (t = l.Object()), e || (e = l.Object());
                        var r = t.Number || l.Number,
                            o = t.String || l.String,
                            a = t.Object || l.Object,
                            u = t.Date || l.Date,
                            c = t.SyntaxError || l.SyntaxError,
                            f = t.TypeError || l.TypeError,
                            h = t.Math || l.Math,
                            d = t.JSON || l.JSON;
                        "object" == typeof d && d && (e.stringify = d.stringify, e.parse = d.parse);
                        var p, v, m, b = a.prototype,
                            y = b.toString,
                            g = new u(-0xc782b5b800cec);
                        try {
                            g = -109252 == g.getUTCFullYear() && 0 === g.getUTCMonth() && 1 === g.getUTCDate() && 10 == g.getUTCHours() && 37 == g.getUTCMinutes() && 6 == g.getUTCSeconds() && 708 == g.getUTCMilliseconds()
                        } catch (t) {}
                        if (!n("json")) {
                            var w = n("bug-string-char-index");
                            if (!g) var x = h.floor,
                                _ = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334],
                                E = function(t, e) {
                                    return _[e] + 365 * (t - 1970) + x((t - 1969 + (e = +(e > 1))) / 4) - x((t - 1901 + e) / 100) + x((t - 1601 + e) / 400)
                                };
                            if ((p = b.hasOwnProperty) || (p = function(t) {
                                var e, n = {};
                                return (n.__proto__ = null, n.__proto__ = {
                                    "toString": 1
                                }, n).toString != y ? p = function(t) {
                                    var e = this.__proto__,
                                        n = t in (this.__proto__ = null, this);
                                    return this.__proto__ = e, n
                                } : (e = n.constructor, p = function(t) {
                                    var n = (this.constructor || e).prototype;
                                    return t in this && !(t in n && this[t] === n[t])
                                }), n = null, p.call(this, t)
                            }), v = function(t, e) {
                                var n, r, i, o = 0;
                                (n = function() {
                                    this.valueOf = 0
                                }).prototype.valueOf = 0, r = new n;
                                for (i in r) p.call(r, i) && o++;
                                return n = r = null, o ? v = 2 == o ? function(t, e) {
                                    var n, r = {},
                                        i = "[object Function]" == y.call(t);
                                    for (n in t) i && "prototype" == n || p.call(r, n) || !(r[n] = 1) || !p.call(t, n) || e(n)
                                } : function(t, e) {
                                    var n, r, i = "[object Function]" == y.call(t);
                                    for (n in t) i && "prototype" == n || !p.call(t, n) || (r = "constructor" === n) || e(n);
                                    (r || p.call(t, n = "constructor")) && e(n)
                                } : (r = ["valueOf", "toString", "toLocaleString", "propertyIsEnumerable", "isPrototypeOf", "hasOwnProperty", "constructor"], v = function(t, e) {
                                    var n, i, o = "[object Function]" == y.call(t),
                                        a = !o && "function" != typeof t.constructor && s[typeof t.hasOwnProperty] && t.hasOwnProperty || p;
                                    for (n in t) o && "prototype" == n || !a.call(t, n) || e(n);
                                    for (i = r.length; n = r[--i]; a.call(t, n) && e(n));
                                }), v(t, e)
                            }, !n("json-stringify")) {
                                var j = {
                                        92: "\\\\",
                                        34: '\\"',
                                        8: "\\b",
                                        12: "\\f",
                                        10: "\\n",
                                        13: "\\r",
                                        9: "\\t"
                                    },
                                    S = function(t, e) {
                                        return ("000000" + (e || 0)).slice(-t)
                                    },
                                    T = function(t) {
                                        for (var e = '"', n = 0, r = t.length, i = !w || r > 10, o = i && (w ? t.split("") : t); n < r; n++) {
                                            var s = t.charCodeAt(n);
                                            switch (s) {
                                                case 8:
                                                case 9:
                                                case 10:
                                                case 12:
                                                case 13:
                                                case 34:
                                                case 92:
                                                    e += j[s];
                                                    break;
                                                default:
                                                    if (s < 32) {
                                                        e += "\\u00" + S(2, s.toString(16));
                                                        break
                                                    }
                                                    e += i ? o[n] : t.charAt(n)
                                            }
                                        }
                                        return e + '"'
                                    },
                                    O = function(t, e, n, r, i, o, s) {
                                        var a, l, u, c, h, d, b, g, w, _, j, C, N, A, k, I;
                                        try {
                                            a = e[t]
                                        } catch (t) {}
                                        if ("object" == typeof a && a)
                                            if ("[object Date]" != (l = y.call(a)) || p.call(a, "toJSON")) "function" == typeof a.toJSON && ("[object Number]" != l && "[object String]" != l && "[object Array]" != l || p.call(a, "toJSON")) && (a = a.toJSON(t));
                                            else if (a > -1 / 0 && a < 1 / 0) {
                                                if (E) {
                                                    for (h = x(a / 864e5), u = x(h / 365.2425) + 1970 - 1; E(u + 1, 0) <= h; u++);
                                                    for (c = x((h - E(u, 0)) / 30.42); E(u, c + 1) <= h; c++);
                                                    h = 1 + h - E(u, c), d = (a % 864e5 + 864e5) % 864e5, b = x(d / 36e5) % 24, g = x(d / 6e4) % 60, w = x(d / 1e3) % 60, _ = d % 1e3
                                                } else u = a.getUTCFullYear(), c = a.getUTCMonth(), h = a.getUTCDate(), b = a.getUTCHours(), g = a.getUTCMinutes(), w = a.getUTCSeconds(), _ = a.getUTCMilliseconds();
                                                a = (u <= 0 || u >= 1e4 ? (u < 0 ? "-" : "+") + S(6, u < 0 ? -u : u) : S(4, u)) + "-" + S(2, c + 1) + "-" + S(2, h) + "T" + S(2, b) + ":" + S(2, g) + ":" + S(2, w) + "." + S(3, _) + "Z"
                                            } else a = null;
                                        if (n && (a = n.call(e, t, a)), null === a) return "null";
                                        if ("[object Boolean]" == (l = y.call(a))) return "" + a;
                                        if ("[object Number]" == l) return a > -1 / 0 && a < 1 / 0 ? "" + a : "null";
                                        if ("[object String]" == l) return T("" + a);
                                        if ("object" == typeof a) {
                                            for (A = s.length; A--;)
                                                if (s[A] === a) throw f();
                                            if (s.push(a), j = [], k = o, o += i, "[object Array]" == l) {
                                                for (N = 0, A = a.length; N < A; N++) C = O(N, a, n, r, i, o, s), j.push(C === m ? "null" : C);
                                                I = j.length ? i ? "[\n" + o + j.join(",\n" + o) + "\n" + k + "]" : "[" + j.join(",") + "]" : "[]"
                                            } else v(r || a, function(t) {
                                                var e = O(t, a, n, r, i, o, s);
                                                e !== m && j.push(T(t) + ":" + (i ? " " : "") + e)
                                            }), I = j.length ? i ? "{\n" + o + j.join(",\n" + o) + "\n" + k + "}" : "{" + j.join(",") + "}" : "{}";
                                            return s.pop(), I
                                        }
                                    };
                                e.stringify = function(t, e, n) {
                                    var r, i, o, a;
                                    if (s[typeof e] && e)
                                        if ("[object Function]" == (a = y.call(e))) i = e;
                                        else if ("[object Array]" == a) {
                                            o = {};
                                            for (var l, u = 0, c = e.length; u < c; l = e[u++], ("[object String]" == (a = y.call(l)) || "[object Number]" == a) && (o[l] = 1));
                                        }
                                    if (n)
                                        if ("[object Number]" == (a = y.call(n))) {
                                            if ((n -= n % 1) > 0)
                                                for (r = "", n > 10 && (n = 10); r.length < n; r += " ");
                                        } else "[object String]" == a && (r = n.length <= 10 ? n : n.slice(0, 10));
                                    return O("", (l = {}, l[""] = t, l), i, o, r, "", [])
                                }
                            }
                            if (!n("json-parse")) {
                                var C, N, A = o.fromCharCode,
                                    k = {
                                        92: "\\",
                                        34: '"',
                                        47: "/",
                                        98: "\b",
                                        116: "\t",
                                        110: "\n",
                                        102: "\f",
                                        114: "\r"
                                    },
                                    I = function() {
                                        throw C = N = null, c()
                                    },
                                    P = function() {
                                        for (var t, e, n, r, i, o = N, s = o.length; C < s;) switch (i = o.charCodeAt(C)) {
                                            case 9:
                                            case 10:
                                            case 13:
                                            case 32:
                                                C++;
                                                break;
                                            case 123:
                                            case 125:
                                            case 91:
                                            case 93:
                                            case 58:
                                            case 44:
                                                return t = w ? o.charAt(C) : o[C], C++, t;
                                            case 34:
                                                for (t = "@", C++; C < s;)
                                                    if ((i = o.charCodeAt(C)) < 32) I();
                                                    else if (92 == i) switch (i = o.charCodeAt(++C)) {
                                                        case 92:
                                                        case 34:
                                                        case 47:
                                                        case 98:
                                                        case 116:
                                                        case 110:
                                                        case 102:
                                                        case 114:
                                                            t += k[i], C++;
                                                            break;
                                                        case 117:
                                                            for (e = ++C, n = C + 4; C < n; C++)(i = o.charCodeAt(C)) >= 48 && i <= 57 || i >= 97 && i <= 102 || i >= 65 && i <= 70 || I();
                                                            t += A("0x" + o.slice(e, C));
                                                            break;
                                                        default:
                                                            I()
                                                    } else {
                                                        if (34 == i) break;
                                                        for (i = o.charCodeAt(C), e = C; i >= 32 && 92 != i && 34 != i;) i = o.charCodeAt(++C);
                                                        t += o.slice(e, C)
                                                    }
                                                if (34 == o.charCodeAt(C)) return C++, t;
                                                I();
                                            default:
                                                if (e = C, 45 == i && (r = !0, i = o.charCodeAt(++C)), i >= 48 && i <= 57) {
                                                    for (48 == i && (i = o.charCodeAt(C + 1)) >= 48 && i <= 57 && I(), r = !1; C < s && (i = o.charCodeAt(C)) >= 48 && i <= 57; C++);
                                                    if (46 == o.charCodeAt(C)) {
                                                        for (n = ++C; n < s && (i = o.charCodeAt(n)) >= 48 && i <= 57; n++);
                                                        n == C && I(), C = n
                                                    }
                                                    if (101 == (i = o.charCodeAt(C)) || 69 == i) {
                                                        for (i = o.charCodeAt(++C), 43 != i && 45 != i || C++, n = C; n < s && (i = o.charCodeAt(n)) >= 48 && i <= 57; n++);
                                                        n == C && I(), C = n
                                                    }
                                                    return +o.slice(e, C)
                                                }
                                                if (r && I(), "true" == o.slice(C, C + 4)) return C += 4, !0;
                                                if ("false" == o.slice(C, C + 5)) return C += 5, !1;
                                                if ("null" == o.slice(C, C + 4)) return C += 4, null;
                                                I()
                                        }
                                        return "$"
                                    },
                                    L = function(t) {
                                        var e, n;
                                        if ("$" == t && I(), "string" == typeof t) {
                                            if ("@" == (w ? t.charAt(0) : t[0])) return t.slice(1);
                                            if ("[" == t) {
                                                for (e = [];
                                                     "]" != (t = P()); n || (n = !0)) n && ("," == t ? "]" == (t = P()) && I() : I()), "," == t && I(), e.push(L(t));
                                                return e
                                            }
                                            if ("{" == t) {
                                                for (e = {};
                                                     "}" != (t = P()); n || (n = !0)) n && ("," == t ? "}" == (t = P()) && I() : I()), "," != t && "string" == typeof t && "@" == (w ? t.charAt(0) : t[0]) && ":" == P() || I(), e[t.slice(1)] = L(P());
                                                return e
                                            }
                                            I()
                                        }
                                        return t
                                    },
                                    R = function(t, e, n) {
                                        var r = U(t, e, n);
                                        r === m ? delete t[e] : t[e] = r
                                    },
                                    U = function(t, e, n) {
                                        var r, i = t[e];
                                        if ("object" == typeof i && i)
                                            if ("[object Array]" == y.call(i))
                                                for (r = i.length; r--;) R(i, r, n);
                                            else v(i, function(t) {
                                                R(i, t, n)
                                            });
                                        return n.call(t, e, i)
                                    };
                                e.parse = function(t, e) {
                                    var n, r;
                                    return C = 0, N = "" + t, n = L(P()), "$" != P() && I(), C = N = null, e && "[object Function]" == y.call(e) ? U((r = {}, r[""] = n, r), "", e) : n
                                }
                            }
                        }
                        return e.runInContext = i, e
                    }
                    var o = "function" == typeof t && t.amd,
                        s = {
                            "function": !0,
                            "object": !0
                        },
                        a = s[typeof r] && r && !r.nodeType && r,
                        l = s[typeof window] && window || this,
                        u = a && s[typeof n] && n && !n.nodeType && "object" == typeof e && e;
                    if (!u || u.global !== u && u.window !== u && u.self !== u || (l = u), a && !o) i(l, a);
                    else {
                        var c = l.JSON,
                            f = l.JSON3,
                            h = !1,
                            d = i(l, l.JSON3 = {
                                "noConflict": function() {
                                    return h || (h = !0, l.JSON = c, l.JSON3 = f, c = f = null), d
                                }
                            });
                        l.JSON = {
                            "parse": d.parse,
                            "stringify": d.stringify
                        }
                    }
                    o && t(function() {
                        return d
                    })
                }).call(this)
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {}],
        56: [function(t, e, n) {
            "use strict";

            function r(t) {
                for (var e, n = /([^=?&]+)=?([^&]*)/g, r = {}; e = n.exec(t); r[decodeURIComponent(e[1])] = decodeURIComponent(e[2]));
                return r
            }

            function i(t, e) {
                e = e || "";
                var n = [];
                "string" != typeof e && (e = "?");
                for (var r in t) o.call(t, r) && n.push(encodeURIComponent(r) + "=" + encodeURIComponent(t[r]));
                return n.length ? e + n.join("&") : ""
            }
            var o = Object.prototype.hasOwnProperty;
            n.stringify = i, n.parse = r
        }, {}],
        57: [function(t, e, n) {
            "use strict";
            e.exports = function(t, e) {
                if (e = e.split(":")[0], !(t = +t)) return !1;
                switch (e) {
                    case "http":
                    case "ws":
                        return 80 !== t;
                    case "https":
                    case "wss":
                        return 443 !== t;
                    case "ftp":
                        return 21 !== t;
                    case "gopher":
                        return 70 !== t;
                    case "file":
                        return !1
                }
                return 0 !== t
            }
        }, {}],
        58: [function(t, e, n) {
            "use strict";

            function r(t) {
                var e = f.exec(t);
                return {
                    protocol: e[1] ? e[1].toLowerCase() : "",
                    slashes: !!e[2],
                    rest: e[3]
                }
            }

            function i(t, e) {
                for (var n = (e || "/").split("/").slice(0, -1).concat(t.split("/")), r = n.length, i = n[r - 1], o = !1, s = 0; r--;) "." === n[r] ? n.splice(r, 1) : ".." === n[r] ? (n.splice(r, 1), s++) : s && (0 === r && (o = !0), n.splice(r, 1), s--);
                return o && n.unshift(""), "." !== i && ".." !== i || n.push(""), n.join("/")
            }

            function o(t, e, n) {
                if (!(this instanceof o)) return new o(t, e, n);
                var s, a, f, d, p, v, m = h.slice(),
                    b = typeof e,
                    y = this,
                    g = 0;
                for ("object" !== b && "string" !== b && (n = e, e = null), n && "function" != typeof n && (n = c.parse), e = u(e), a = r(t || ""), s = !a.protocol && !a.slashes, y.slashes = a.slashes || s && e.slashes, y.protocol = a.protocol || e.protocol || "", t = a.rest, a.slashes || (m[2] = [/(.*)/, "pathname"]); g < m.length; g++) d = m[g], f = d[0], v = d[1], f !== f ? y[v] = t : "string" == typeof f ? ~(p = t.indexOf(f)) && ("number" == typeof d[2] ? (y[v] = t.slice(0, p), t = t.slice(p + d[2])) : (y[v] = t.slice(p), t = t.slice(0, p))) : (p = f.exec(t)) && (y[v] = p[1], t = t.slice(0, p.index)), y[v] = y[v] || (s && d[3] ? e[v] || "" : ""), d[4] && (y[v] = y[v].toLowerCase());
                n && (y.query = n(y.query)), s && e.slashes && "/" !== y.pathname.charAt(0) && ("" !== y.pathname || "" !== e.pathname) && (y.pathname = i(y.pathname, e.pathname)), l(y.port, y.protocol) || (y.host = y.hostname, y.port = ""), y.username = y.password = "", y.auth && (d = y.auth.split(":"), y.username = d[0] || "", y.password = d[1] || ""), y.origin = y.protocol && y.host && "file:" !== y.protocol ? y.protocol + "//" + y.host : "null", y.href = y.toString()
            }

            function s(t, e, n) {
                var r = this;
                switch (t) {
                    case "query":
                        "string" == typeof e && e.length && (e = (n || c.parse)(e)), r[t] = e;
                        break;
                    case "port":
                        r[t] = e, l(e, r.protocol) ? e && (r.host = r.hostname + ":" + e) : (r.host = r.hostname, r[t] = "");
                        break;
                    case "hostname":
                        r[t] = e, r.port && (e += ":" + r.port), r.host = e;
                        break;
                    case "host":
                        r[t] = e, /:\d+$/.test(e) ? (e = e.split(":"), r.port = e.pop(), r.hostname = e.join(":")) : (r.hostname = e, r.port = "");
                        break;
                    case "protocol":
                        r.protocol = e.toLowerCase(), r.slashes = !n;
                        break;
                    case "pathname":
                        r.pathname = e.length && "/" !== e.charAt(0) ? "/" + e : e;
                        break;
                    default:
                        r[t] = e
                }
                for (var i = 0; i < h.length; i++) {
                    var o = h[i];
                    o[4] && (r[o[1]] = r[o[1]].toLowerCase())
                }
                return r.origin = r.protocol && r.host && "file:" !== r.protocol ? r.protocol + "//" + r.host : "null", r.href = r.toString(), r
            }

            function a(t) {
                t && "function" == typeof t || (t = c.stringify);
                var e, n = this,
                    r = n.protocol;
                r && ":" !== r.charAt(r.length - 1) && (r += ":");
                var i = r + (n.slashes ? "//" : "");
                return n.username && (i += n.username, n.password && (i += ":" + n.password), i += "@"), i += n.host + n.pathname, e = "object" == typeof n.query ? t(n.query) : n.query, e && (i += "?" !== e.charAt(0) ? "?" + e : e), n.hash && (i += n.hash), i
            }
            var l = t("requires-port"),
                u = t("./lolcation"),
                c = t("querystringify"),
                f = /^([a-z][a-z0-9.+-]*:)?(\/\/)?([\S\s]*)/i,
                h = [
                    ["#", "hash"],
                    ["?", "query"],
                    ["/", "pathname"],
                    ["@", "auth", 1],
                    [NaN, "host", void 0, 1, 1],
                    [/:(\d+)$/, "port", void 0, 1],
                    [NaN, "hostname", void 0, 1, 1]
                ];
            o.prototype = {
                set: s,
                toString: a
            }, o.extractProtocol = r, o.location = u, o.qs = c, e.exports = o
        }, {
            "./lolcation": 59,
            "querystringify": 56,
            "requires-port": 57
        }],
        59: [function(t, e, n) {
            (function(n) {
                "use strict";
                var r, i = /^[A-Za-z][A-Za-z0-9+-.]*:\/\//,
                    o = {
                        hash: 1,
                        query: 1
                    };
                e.exports = function(e) {
                    e = e || n.location || {}, r = r || t("./");
                    var s, a = {},
                        l = typeof e;
                    if ("blob:" === e.protocol) a = new r(unescape(e.pathname), {});
                    else if ("string" === l) {
                        a = new r(e, {});
                        for (s in o) delete a[s]
                    } else if ("object" === l) {
                        for (s in e) s in o || (a[s] = e[s]);
                        void 0 === a.slashes && (a.slashes = i.test(e.href))
                    }
                    return a
                }
            }).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
        }, {
            "./": 58
        }]
    }, {}, [1])(1)
});