/*Copyright 2016 Deepak Kumar
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
This code is written by Deepak Kumar */

package bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="ata_tbl_credit_card")
public class CreditCardBean
{
	    @Id
	    @Column(name="credit_card_number")
	    private String  creditCardNumber;
	    @Column(name="valid_from")
	    @Temporal(TemporalType.DATE)
	    private Date validFrom;
	    @Column(name="valid_to")
	    @Temporal(TemporalType.DATE)
	    private Date validTo;
	    @Column(name="credit_balance")
	    private float creditBalance;

		public String getCreditCardNumber() {
			return creditCardNumber;
		}
		public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}
		public Date getValidFrom() {
			return validFrom;
		}
		public void setValidFrom(Date validFrom) {
			this.validFrom = validFrom;
		}
		public Date getValidTo() {
			return validTo;
		}
		public void setValidTo(Date validTo) {
			this.validTo = validTo;
		}
		public float getCreditBalance() {
			return creditBalance;
		}
		public void setCreditBalance(float creditBalance) {
			this.creditBalance = creditBalance;
		}

}
