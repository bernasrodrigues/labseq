import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class LabseqService {
  private baseUrl: string = 'http://localhost:8080/labseq';

  async getLabseqValue(n: number): Promise<string> {
    const response = await axios.get(`${this.baseUrl}/${n}`);
    return response.data;
  }
}
