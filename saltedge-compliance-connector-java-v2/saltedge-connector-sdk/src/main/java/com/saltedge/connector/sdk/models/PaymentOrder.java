/*
 * @author Constantin Chelban (constantink@saltedge.com)
 * Copyright (c) 2020 Salt Edge.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.saltedge.connector.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.saltedge.connector.sdk.SDKConstants;
import com.saltedge.connector.sdk.provider.models.Amount;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Payment data.
 */
@JsonIgnoreProperties
public class PaymentOrder {
    /**
     * Creditor data.
     */
    @JsonProperty("creditor_account")
    @NotNull
    @Valid
    public Account creditorAccount;

    /**
     * Creditor full name.
     */
    @JsonProperty("creditor_name")
    @NotEmpty
    public String creditorName;

    /**
     * Debtor data.
     */
    @JsonProperty("debtor_account")
    @NotNull
    @Valid
    public Account debtorAccount;

    /**
     * Amount and currency.
     */
    @JsonProperty("instructed_amount")
    @NotNull
    @Valid
    public Amount instructedAmount;

    /**
     * Payment identifier on TPP side.
     */
    @JsonProperty(SDKConstants.KEY_END_TO_END_IDENTIFICATION)
    public String endToEndIdentification;

    /**
     * Payment description.
     */
    @JsonProperty("remittance_information_unstructured")
    public String remittanceInformationUnstructured;

    public PaymentOrder() {
    }

    public PaymentOrder(
            @NotNull @Valid Account creditorAccount,
            @NotEmpty String creditorName,
            @NotNull @Valid Account debtorAccount,
            @NotNull @Valid Amount instructedAmount,
            String endToEndIdentification,
            String remittanceInformationUnstructured
    ) {
        this.creditorAccount = creditorAccount;
        this.creditorName = creditorName;
        this.debtorAccount = debtorAccount;
        this.instructedAmount = instructedAmount;
        this.endToEndIdentification = endToEndIdentification;
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }

    /**
     * Payment account
     */
    public static class Account {
        /**
         * International Bank Account Number
         */
        @JsonProperty(SDKConstants.KEY_IBAN)
        @NotEmpty
        public String iban;

        public Account() {
        }

        public Account(@NotEmpty String iban) {
            this.iban = iban;
        }
    }
}
