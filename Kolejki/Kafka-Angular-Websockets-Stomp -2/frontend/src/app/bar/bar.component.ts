import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartConfiguration, ChartData, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import DataLabelsPlugin from 'chartjs-plugin-datalabels';
import { DemoserviceService } from '../demoservice.service';

@Component({
  selector: 'app-bar',
  templateUrl: './bar.component.html',
  styleUrl: './bar.component.css'
})
export class BarComponent implements OnInit {
  @ViewChild(BaseChartDirective) chart: BaseChartDirective | undefined;
  private carsale:string = "";
  get GetCarSale(): string {
    return this.carsale;
  }
  public barChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: {
      x: {},
      y: {
        min: 0
      }
    },
    plugins: {
      title: {
        display: true,
        text: 'Total Sales by Model',
        padding:{
          bottom:30,
          top:30
        },
        fullSize:true,
        
      },
      legend: {
        display: true,
        position:'bottom'
      },
      datalabels: {
        anchor: 'end',
        align: 'end'
      }
    }
  };
  public barChartType: ChartType = 'bar';
  public barChartPlugins = [DataLabelsPlugin];
  public barChartData: ChartData<'bar'> = {
    labels: [ 'Models' ],
    datasets: [
      { data: [], 
        label: '' } 
    ]
  };
  
  constructor(private demoservice:DemoserviceService) { }
  
  ngOnInit(): void {
    this.demoservice.dataModel.subscribe(p=>                
      {
        this.carsale =p.totalSales;
         if(p && p.carModelSales){       
          this.barChartData.datasets = p.carModelSales;         
          this.chart?.update();             
         }
     });    
  }   
}